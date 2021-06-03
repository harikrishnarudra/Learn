package couchbase;

import com.couchbase.client.core.env.TimeoutConfig;
import com.couchbase.client.core.service.QueryServiceConfig;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.ClusterOptions;
import com.couchbase.client.java.env.ClusterEnvironment;
import com.couchbase.client.java.query.QueryResult;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class RunQueryWithCB {
    public static void main(String[] args) throws IOException {

        TimeoutConfig.Builder connectTimeout = TimeoutConfig.kvTimeout(Duration.ofMillis(30000))
                .queryTimeout(Duration.ofMillis(30000))
                .connectTimeout(Duration.ofMillis(20000));

        ClusterEnvironment clusterEnvironment = ClusterEnvironment.builder().timeoutConfig(connectTimeout).build();

        Cluster cluster = Cluster.connect("localhost", ClusterOptions.clusterOptions("Administrator", "password").environment(clusterEnvironment));
        Bucket bucket = cluster.bucket("priceLocal");

        String query = "SELECT a.gtin, a.locationClusterId, MAX([a.effectiveDateTime,{a.basePrice, a.tpnb, a.subClass,a.priceMarked} ])[1].*,MILLIS_TO_STR(MAX([a.effectiveDateTime,{a.effectiveDateTime} ])[1].effectiveDateTime) as effectiveDateTime,\n" +
                "{\"aec7c8db-013d-414d-bbdd-9226ed96d6fc\":\"1\",\"041fece7-aa93-42c6-9e76-72a43f599498\":\"2\",\"f6458c43-25c0-4c24-935f-4f284041d573\":\"3\",\n" +
                "\"f9a5d04f-5980-4a0a-9ee4-5af726962f9e\":\"14\",\"967badfc-9889-4b4b-b7e9-3e30e55316e7\":\"24\",\"05e7673f-b28d-491a-82b4-08a836112e2a\":\"4\",\n" +
                "\"3a870577-e41e-4a9a-8b2f-dfc80804409e\":\"16\",\"212a9988-a503-4f30-bacd-a9d672ec2c9a\":\"18\"}.[locationClusterId] AS zoneId \n" +
                "FROM priceLocal as a\n" +
                "WHERE a._class IN ['com.tesco.api.price.domain.entity.InitialPrice','com.tesco.api.price.domain.entity.PriceChange'] \n" +
                "AND a.subClass IN [STR_PLACE_HOLDER]\n" +
                "AND a.effectiveDateTime <= NOW_MILLIS()\n" +
//                "And a.state = \"APPROVED\"\n" +
                "group by a.gtin,a.locationClusterId\n" +
                "order by gtin, effectiveDateTime";

        QueryResult result = null;
        File file = new File("/Users/harikrishnarudra/Downloads/PriceSetup/Texts/Test_SC");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String st;
        int batchSize = 110;
        int i = 100;
        String commaSeperated = "";
        while ((st = bufferedReader.readLine()) != null){
            if (i<batchSize){
                commaSeperated += st;
                i++;
            }
            else {
                System.out.println(commaSeperated);
                String substring = commaSeperated;
                if (commaSeperated.endsWith(",")) {
                    substring = commaSeperated.substring(0, commaSeperated.lastIndexOf(","));
                    System.out.println(substring);
                }
                query = query.replaceAll("STR_PLACE_HOLDER", substring);
                result = cluster.query(query);
                System.out.println(result.rowsAsObject());
                i = 0;
            }
        }
    }

    /*private Mono<List<String>> findAllActiveAndFutureIntentIdsBySubClasses(RulesValidationForMigratedDataRequest rulesValidationForMigratedDataRequest) {
        return Flux.just(rulesValidationForMigratedDataRequest)
                .flatMap(rulesValidationRequest -> priceChangeCouchbaseRepository.findAllFuturePriceChangeIdsBySubClass(JsonArray.from(rulesValidationForMigratedDataRequest.getSubClasses()), Instant.now(), PriceChangeState.APPROVED.name()))
                .collectList()
                .doOnNext(futurePriceChangeIds -> log.info("MSG='Successfully fetched future priceChangeIds by subclass', noOfFuturePriceChangeIdsBySubclass={}", futurePriceChangeIds.size()))
                .flatMap(futurePriceChangeIds -> findAllActivePriceChangeIdsBySubClassList(futurePriceChangeIds, rulesValidationForMigratedDataRequest.getSubClasses()))
                .doOnError(error -> log.error("MSG=Error while fetching future priceChangeIds by subClassList", error))
                .switchIfEmpty(Mono.defer(() -> findAllActivePriceChangeIdsBySubClassList(new ArrayList<>(), rulesValidationForMigratedDataRequest.getSubClasses())))
                .retryWhen(retry.createRetry(dbRetryConfigHelper.getDBRetryConfigs(), log));
    }*/

}
