package couchbase;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.query.QueryResult;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CreateIndexesMain {

    public static void main(String[] args) throws Exception{
        Cluster cluster = Cluster.connect("localhost","Administrator","password");
        Bucket bucket = cluster.bucket("prices");

        QueryResult result = null;

        /*File file = new File("/Users/harikrishnarudra/Downloads/PriceSetup/Texts/Index/QueryService.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String st;
        while ((st = bufferedReader.readLine()) != null){
            System.out.println("Index creating is "+st);
            result = cluster.query(st);
            System.out.println(result.rowsAsObject());
        }*/

        //Rules
        /*
        result = cluster.query("CREATE INDEX `pricemgrtn_rules_DISTINCT_productDSL_parameters_tpnb_effectiveDateTime` ON\n" +
                "`prices`(DISTINCT ARRAY `tpnb` FOR tpnb in `productDSL`.`parameters`.`tpnb` END,`effectiveDateTime`) PARTITION BY HASH(META().id)\n" +
                "WHERE `state` = 'APPROVED' AND _class in ['com.tesco.api.price.migration.domain.entity.MigratedPriceChangeIntent','com.tesco.api.price.migration.domain.entity.MigratedInitialPriceIntent']\n" +
                "USING GSI WITH {\"num_partition\":1};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `pricemgrtn_rules_meta_subClass_effectiveDateTime` ON\n" +
                "`prices`(`meta`.`subClass`,`effectiveDateTime`) PARTITION BY HASH(META().id)\n" +
                "WHERE `state` = 'APPROVED' AND _class in ['com.tesco.api.price.migration.domain.entity.MigratedPriceChangeIntent','com.tesco.api.price.migration.domain.entity.MigratedInitialPriceIntent']\n" +
                "USING GSI WITH {\"num_partition\":1};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `pricemgrtn_rules_subClass_status` ON\n" +
                "`priceMigrations`(`subClass`,`status`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.model.RulesValidationResult'\n" +
                "USING GSI WITH {\"num_partition\":1};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `pricemgrtn_rules_tpnb_status` ON\n" +
                "`priceMigrations`(`tpnb`,`status`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.model.RulesValidationResult'\n" +
                "USING GSI WITH {\"num_partition\":1};");
        System.out.println(result.rowsAsObject());

        // Reconciliation

        result = cluster.query("CREATE INDEX `pricemgrtn_recon_subclass_messageId_intentRequest_createdDateTime` ON\n" +
                "`prices`(`subClass`,`messageId`,`intentRequest`.`createdDateTime`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigratedInitialPriceIntent'\n" +
                "USING GSI WITH {\"num_partition\":1};");
        System.out.println(result.rowsAsObject());
        */


        result = cluster.query("CREATE INDEX `pricemgrtn_recon_createdDateTime_priceChangeIntentId_initialPriceIntentId_status` ON\n" +
                "`prices`(`createdDateTime`,`priceChangeIntentId`,`initialPriceIntentId`,`status`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus'\n" +
                "USING GSI WITH {\"num_partition\":1};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `pricemgrtn_recon_subClass_createdDateTime_priceChangeIntentId_initialPriceIntentId_status` ON\n" +
                "`prices`(`subClass`,`createdDateTime`,`priceChangeIntentId`,`initialPriceIntentId`,`status`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus'\n" +
                "USING GSI WITH {\"num_partition\":1};\n");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `pricemgrtn_recon_subClass_createdDateTime_extId_priceChangeIntentId_initialPriceIntentId` ON\n" +
                "`prices`(`subClass`,`createdDateTime`,`extId`,`priceChangeIntentId`,`initialPriceIntentId`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus'\n" +
                "USING GSI WITH {\"num_partition\":1};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `pricemgrtn_recon_subClass_createdDateTime_messageId_priceChangeIntentId_initialPriceIntentId` ON\n" +
                "`prices`(`subClass`,`createdDateTime`,`messageId`,`priceChangeIntentId`,`initialPriceIntentId`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus'\n" +
                "USING GSI WITH {\"num_partition\":1};\n");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `pricemgrtn_recon_createdDateTime_extId_priceChangeIntentId_initialPriceIntentId` ON\n" +
                "`prices`(`createdDateTime`,`extId`,`priceChangeIntentId`,`initialPriceIntentId`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus'\n" +
                "USING GSI WITH {\"num_partition\":1};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `pricemgrtn_recon_messageId_createdDateTime_priceChangeIntentId_status_subClass` ON\n" +
                "`prices`(`messageId`,`createdDateTime`,`priceChangeIntentId`,`status`,`subClass`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus'\n" +
                "USING GSI WITH {\"num_partition\":1};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `pricemgrtn_recon_messageId_createdDateTime_initialPriceIntentId_status_subClass` ON\n" +
                "`prices`(`messageId`,`createdDateTime`,`initialPriceIntentId`,`status`,`subClass`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus'\n" +
                "USING GSI WITH {\"num_partition\":1};\n");
        System.out.println(result.rowsAsObject());




        /*
        result = cluster.query("CREATE INDEX `pricecmd_id_and_class` ON `priceLocal`(META().id,`_class`) USING GSI");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `pricecmd_IP_InitialPriceIntentIdIndex` ON `priceLocal`(`initialPriceIntentId`) WHERE (`_class` = \"com.tesco.api.price.domain.entity.InitialPrice\") USING GSI");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `pricecmd_getPriceChanges_gtins_byPciId` ON `priceLocal`(`pciId`,`gtin`)\n" +
                "PARTITION BY HASH(`pciId`)\n" +
                "WHERE (`_class` = \"com.tesco.api.price.domain.entity.PriceChange\")\n" +
                "USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `pricecmd_effectiveDateTime_PCI` ON `priceLocal`(`effectiveDateTime`)\n" +
                "PARTITION BY HASH(`effectiveDateTime`)\n" +
                "WHERE (`_class` = \"com.tesco.api.price.domain.entity.PriceChangeIntent\")\n" +
                "USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `pricecmd_effectiveDateTime_IPI` ON `priceLocal`(`effectiveDateTime`)\n" +
                "PARTITION BY HASH(`effectiveDateTime`)\n" +
                "WHERE (`_class` = \"com.tesco.api.price.domain.entity.InitialPriceIntent\")\n" +
                "USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `pricecmd_locationClusterId_gtin_state_class_effectiveDateTime` ON `priceLocal`(`locationClusterId`,`gtin`,`state`,`_class`,`effectiveDateTime`)\n" +
                "PARTITION BY HASH(`locationClusterId`,`gtin`,`effectiveDateTime`)\n" +
                "USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX pricecmd_all_tpnb_in_MIPI_and_IPI ON priceLocal (ALL productDSL.parameters.tpnb)\n" +
                "PARTITION BY HASH(META().id) WHERE (`_class` IN [\"com.tesco.api.price.domain.entity.InitialPriceIntent\",\"com.tesco.api.price.migration.domain.entity.MigratedInitialPriceIntent\"])\n" +
                "USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX pricecmd_effectiveDateTime_with_all_tpnb_state_intentStatus_in_MPCI_and_PCI ON priceLocal (effectiveDateTime, ALL productDSL.parameters.tpnb, state, intentRequest.status)\n" +
                "PARTITION BY HASH(META().id) WHERE (`_class` IN [\"com.tesco.api.price.domain.entity.PriceChangeIntent\",\"com.tesco.api.price.migration.domain.entity.MigratedPriceChangeIntent\"])\n" +
                "USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX pricecmd_all_locations_in_MPCI_and_PCI ON priceLocal (effectiveDateTime, ALL locationDSL.parameters.locationClusterId)\n" +
                "PARTITION BY HASH(META().id) WHERE (`_class` IN [\"com.tesco.api.price.domain.entity.PriceChangeIntent\",\"com.tesco.api.price.migration.domain.entity.MigratedPriceChangeIntent\"])\n" +
                "USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX pricecmd_effectiveDateTime_in_MPCI_and_PCI ON priceLocal (effectiveDateTime)\n" +
                "PARTITION BY HASH(META().id) WHERE (`_class` IN [\"com.tesco.api.price.domain.entity.PriceChangeIntent\",\"com.tesco.api.price.migration.domain.entity.MigratedPriceChangeIntent\"])\n" +
                "USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX pricecmd_product_implicit_changes_current_prices ON priceLocal (`itemNumber`,`effectiveDateTime`,`locationClusterId`)\n" +
                "PARTITION BY HASH(META().id) WHERE (`_class` IN [\"com.tesco.api.price.domain.entity.PriceChange\",\"com.tesco.api.price.domain.entity.InitialPrice\"]) and state = 'APPROVED'\n" +
                "USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());


        //Query Service

        result = cluster.query("CREATE INDEX `priceqry_gtinAndLocationClusterIdAndEffectiveDateTime_Index`\n" +
                "ON `priceLocal`(gtin,locationClusterId,effectiveDateTime)\n" +
                "WHERE _class = 'com.tesco.api.price.domain.entity.BasePriceByClusterGtin'\n" +
                "USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `priceqry_priceChangeIntentId_index` ON `priceLocal`(`priceChangeIntentId`)\n" +
                "WHERE (`_class` = \"com.tesco.api.price.domain.entity.BasePriceByClusterGtin\")\n" +
                "USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `priceqry_initialPriceIntentId_index` ON `priceLocal`(`initialPriceIntentId`)\n" +
                "WHERE (`_class` = \"com.tesco.api.price.domain.entity.BasePriceByClusterGtin\")\n" +
                "USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `basePrice_created_date_time` ON `priceLocal`(`createdDateTime`)\n" +
                "WHERE (`_class` = \"com.tesco.api.price.domain.entity.BasePriceByClusterGtin\")\n" +
                "USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        */
        //Migration Service

        /*
        result = cluster.query("CREATE INDEX `migration_pricechangeintent_legacy_extid` ON\n" +
                "`prices`(legacy.extId) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` =\"com.tesco.api.price.migration.domain.entity.MigratedPriceChangeIntent\"\n" +
                "USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());


        result = cluster.query("CREATE INDEX `migrated_baseprice` ON `prices`(`priceChangeIntentId`)\n" +
                "WHERE (`_class` = \"com.tesco.api.price.domain.entity.BasePriceByClusterGtin\") using GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());


        result = cluster.query("CREATE INDEX `migrated_pricechangeintent_effectiveDateTime` ON `prices`(`effectiveDateTime`)\n" +
                "WHERE (`_class` = \"com.tesco.api.price.migration.domain.entity.MigratedPriceChangeIntent\") using GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());


        result = cluster.query("CREATE INDEX `migrated_priceChange_effectiveDateTime` ON `prices`(`effectiveDateTime`)\n" +
                "WHERE (`_class` = \"com.tesco.api.price.domain.entity.PriceChange\") using GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());


        result = cluster.query("CREATE INDEX `price_Gtins_Index` ON\n" +
                "`prices`(productDSL.parameters.gtin)\n" +
                "WHERE _class ='com.tesco.api.price.migration.domain.entity.MigratedPriceChangeIntent' using GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `migrated_priceIntent_Index` ON\n" +
                "`prices`(`pciId`) PARTITION BY HASH(META().id)\n" +
                "WHERE (`_class` = \"com.tesco.api.price.domain.entity.PriceChange\") USING GSI WITH {\"num_partition\":6};\n");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migration_rules_class_effectiveDateTime_DISTINCT_productDSL_parameters_tpnb ON `prices`(`effectiveDateTime`,DISTINCT ARRAY `tpnb` FOR tpnb in `productDSL`.`parameters`.`tpnb` END)\n" +
                "PARTITION BY HASH(META().id)\n" +
                "WHERE `state` = 'APPROVED'\n" +
                "AND _class in ['com.tesco.api.price.migration.domain.entity.MigratedPriceChangeIntent','com.tesco.api.price.migration.domain.entity.MigratedInitialPriceIntent']\n" +
                "USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migration_rules_class_meta_subClass_effectiveDateTime ON `prices`(`meta`.`subClass`,`effectiveDateTime`) PARTITION BY HASH(META().id)\n" +
                "WHERE `state` = 'APPROVED'\n" +
                "AND _class in ['com.tesco.api.price.migration.domain.entity.MigratedPriceChangeIntent','com.tesco.api.price.migration.domain.entity.MigratedInitialPriceIntent']\n" +
                "USING GSI WITH {\"num_partition\":6};\n");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migration_rule_class_gtin_locationClusterId_state ON `prices`(`effectiveDateTime`,`gtin`,`locationClusterId`) PARTITION BY HASH(META().id)\n" +
                "WHERE `state` = 'APPROVED'\n" +
                "AND _class IN ['com.tesco.api.price.domain.entity.PriceChange','com.tesco.api.price.domain.entity.InitialPrice'] USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migration_class_initialPriceIntentId_pciId ON `prices`(`initialPriceIntentId`,`pciId`)\n" +
                "PARTITION BY HASH(META().id) where _class IN ['com.tesco.api.price.domain.entity.PriceChange','com.tesco.api.price.domain.entity.InitialPrice']\n" +
                "USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migration_rules_subClass_class ON `priceMigrations`(`subClass`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.model.RulesValidationResult' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migration_rule_subClass_class_status ON `priceMigrations`(`subClass`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.model.RulesValidationResult' AND `status` = 'SUCCESS'  USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migration_rule_subClass_class_status_failed ON `priceMigrations`(`subClass`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.model.RulesValidationResult' AND `status` = 'FAILED'  USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migration_rule_subClass_gtin_class_status_failed ON `priceMigrations`(`subClass`,`gtin`) PARTITION BY HASH(META().id)\n" +
                "WHERE `status` = 'FAILED' AND `_class` = 'com.tesco.api.price.migration.domain.model.RulesValidationResult' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migration_rule_subClass_tpnb_class_status_failed ON `priceMigrations`(`subClass`,`tpnb`) PARTITION BY HASH(META().id)\n" +
                "WHERE `status` = 'FAILED' AND `_class` = 'com.tesco.api.price.migration.domain.model.RulesValidationResult' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migration_rule_tpnb_class ON `priceMigrations`(`tpnb`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.model.RulesValidationResult' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migration_rule_tpnb_class_status_success ON `priceMigrations`(`tpnb`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.model.RulesValidationResult' AND `status` = 'SUCCESS' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migration_rule_tpnb_class_status_failed ON `priceMigrations`(`tpnb`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.model.RulesValidationResult' AND `status` = 'FAILED' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migration_rule_tpnb_gtin_class_status ON `priceMigrations`(`tpnb`,`gtin`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.model.RulesValidationResult' AND `status` = 'FAILED' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migration_rule_tpnb_gtin_class_status ON `priceMigrations`(`tpnb`,`gtin`,`status`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.model.RulesValidationResult' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());



        result = cluster.query("CREATE INDEX createdDateTime_priceChangeIntentId_initialPriceIntentId_class ON `prices`(`createdDateTime`,`priceChangeIntentId`,`initialPriceIntentId`) PARTITION BY HASH(META().id) WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX createdDateTime_priceChangeIntentId_initialPriceIntentId_class_status_success ON `prices`(`createdDateTime`,`priceChangeIntentId`,`initialPriceIntentId`) PARTITION BY HASH(META().id) WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus' AND `status` = 'SUCCESS' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX createdDateTime_priceChangeIntentId_initialPriceIntentId_class_status_failed ON `prices`(`createdDateTime`,`priceChangeIntentId`,`initialPriceIntentId`) PARTITION BY HASH(META().id) WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus' AND `status` = 'FAILED' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX createdDateTime_priceChangeIntentId_initialPriceIntentId_class_status_pending ON `prices`(`createdDateTime`,`priceChangeIntentId`,`initialPriceIntentId`) PARTITION BY HASH(META().id) WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus' AND `status` = 'PENDING' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX createdDateTime_priceChangeIntentId_initialPriceIntentId_subClass_class ON `prices`(`createdDateTime`,`priceChangeIntentId`,`initialPriceIntentId`,`subClass`) PARTITION BY HASH(META().id) WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX createdDateTime_priceChangeIntentId_extId_class ON `prices`(`createdDateTime`,`priceChangeIntentId`,`extId`) PARTITION BY HASH(META().id) WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX createdDateTime_initialPriceIntent_class ON `prices`(`intentRequest`.`createdDateTime`) PARTITION BY HASH(META().id) WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigratedInitialPriceIntent' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX createdDateTime_messageId_priceChangeIntentId_initialPriceIntentId_class ON `prices`(`createdDateTime`,`messageId`,`priceChangeIntentId`,`initialPriceIntentId`) PARTITION BY HASH(META().id) WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX subClass_createdDateTime_priceChangeIntentId_initialPriceIntentId_class_status_success ON `prices`(`subClass`,`createdDateTime`,`priceChangeIntentId`,`initialPriceIntentId`) PARTITION BY HASH(META().id) WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus' AND `status` = 'SUCCESS' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX subClass_createdDateTime_priceChangeIntentId_initialPriceIntentId_class_status_failed ON `prices`(`subClass`,`createdDateTime`,`priceChangeIntentId`,`initialPriceIntentId`) PARTITION BY HASH(META().id) WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus' AND `status` = 'FAILED' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX subClass_createdDateTime_priceChangeIntentId_initialPriceIntentId_class_status_pending ON `prices`(`subClass`,`createdDateTime`,`priceChangeIntentId`,`initialPriceIntentId`) PARTITION BY HASH(META().id) WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus' AND `status` = 'PENDING' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX subClass_createdDateTime_extId_priceChangeIntentId_initialPriceIntentId_class ON `prices`(`subClass`,`createdDateTime`,`extId`,`priceChangeIntentId`,`initialPriceIntentId`) PARTITION BY HASH(META().id) WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX subClass_createdDateTime_messageId_priceChangeIntentId_initialPriceIntentId_class ON `prices`(`subClass`,`createdDateTime`,`messageId`,`priceChangeIntentId`,`initialPriceIntentId`) PARTITION BY HASH(META().id) WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX priceChangeIntentId_initialPriceIntentId_class ON `prices`(`priceChangeIntentId`,`initialPriceIntentId`) PARTITION BY HASH(META().id) WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());


        result = cluster.query("CREATE INDEX extId_priceChangeIntentId_initialPriceIntentId_class ON `prices`(`extId`,`priceChangeIntentId`,`initialPriceIntentId`) PARTITION BY HASH(META().id) WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());


        result = cluster.query("CREATE INDEX priceChangeIntentId_initialPriceIntentId_messageId_class ON `prices`(`priceChangeIntentId`,`initialPriceIntentId`,`messageId`) PARTITION BY HASH(META().id) WHERE `_class` = 'com.tesco.api.price.migration.domain.entity.MigrationCommandStatus' USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());


        result = cluster.query("CREATE INDEX `migratedinitialpriceintent_itmno_clusterid` ON\n" +
                "`prices`(DISTINCT ARRAY g FOR g IN locationDSL.parameters.locationClusterId END, itemNumber)\n" +
                "WHERE `_class` =\"com.tesco.api.price.migration.domain.entity.MigratedInitialPriceIntent\"\n" +
                "using GSI with {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `migratedinitialprice_itmno_clusterid` ON\n" +
                "`prices`(itemNumber, locationClusterId)\n" +
                "WHERE `_class` =\"com.tesco.api.price.migration.domain.entity.MigratedInitialPrice\"\n" +
                "using GSI with {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `basepricebyclustergtin_clusterid_gtin` ON\n" +
                "`prices`(locationClusterId, gtin)\n" +
                "WHERE `_class` =\"com.tesco.api.price.domain.entity.BasePriceByClusterGtin\"\n" +
                "using GSI with {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `migrated_Initial_pricechangeintent_idempotencyKey` ON\n" +
                "`prices`(idempotencyKey) PARTITION BY HASH(META().id)\n" +
                "WHERE (`_class` =\"com.tesco.api.price.migration.domain.entity.MigratedInitialPriceIntent\")\n" +
                "USING GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `migrated_initialbaseprice` ON `prices`(`initialPriceIntentId`)\n" +
                "WHERE (`_class` = \"com.tesco.api.price.domain.entity.BasePriceByClusterGtin\") using GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `migrated_initialprice` ON `prices`(`initialPriceIntentId`) PARTITION BY HASH(META().id)\n" +
                "WHERE (`_class` = \"com.tesco.api.price.domain.entity.InitialPrice\") USING GSI WITH {\"num_partition\":6};\n");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `migration_commandstatus_pciId` ON `prices`(`priceChangeIntentId`)\n" +
                "WHERE (`_class` = \"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\")\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());


        result = cluster.query("CREATE INDEX `migration_commandstatus_ipiId` ON `prices`(`initialPriceIntentId`)\n" +
                "WHERE (`_class` = \"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\")\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());


        result = cluster.query("CREATE INDEX migrationCommandStatusIngestionCreatedDateTime_PC_Index ON\n" +
                "prices(createdDateTime)\n" +
                "where _class=\"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\"\n" +
                "AND requestType = \"MigratedPriceIntentCommand\"\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migrationCommandStatusIngestionCreatedDateTime_IP_Index ON\n" +
                "prices(createdDateTime)\n" +
                "where _class=\"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\"\n" +
                "AND requestType = \"MigratedInitialBasePriceIntentCommand\"\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migrationCommandStatusIngestionSubClass_PC_Index ON\n" +
                "prices(subClass)\n" +
                "where _class=\"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\"\n" +
                "AND requestType = \"MigratedPriceIntentCommand\"\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migrationCommandStatusIngestionSubClass_IP_Index ON\n" +
                "prices(subClass)\n" +
                "where _class=\"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\"\n" +
                "AND requestType = \"MigratedInitialBasePriceIntentCommand\"\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migrationCommandStatusIngestionCreatedDateTime_PC_SuccessIndex ON\n" +
                "prices(createdDateTime)\n" +
                "where _class=\"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\"\n" +
                "AND requestType = \"MigratedPriceIntentCommand\"\n" +
                "AND status = \"SUCCESS\"\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migrationCommandStatusIngestionCreatedDateTime_PC_failedIndex ON\n" +
                "prices(createdDateTime)\n" +
                "where _class=\"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\"\n" +
                "AND requestType = \"MigratedPriceIntentCommand\"\n" +
                "AND status = \"FAILED\"\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migrationCommandStatusIngestionCreatedDateTimeMessageId_PC_failedIndex ON\n" +
                "prices(createdDateTime,messageId)\n" +
                "where _class=\"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\"\n" +
                "AND requestType = \"MigratedPriceIntentCommand\"\n" +
                "AND status = \"FAILED\"\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migrationCommandStatusIngestionCreatedDateTimeMessageId_PC_pendingIndex ON\n" +
                "prices(createdDateTime,messageId)\n" +
                "where _class=\"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\"\n" +
                "AND requestType = \"MigratedPriceIntentCommand\"\n" +
                "AND status = \"PENDING\"\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migrationCommandStatusIngestionCreatedDateTime_PC_pendingIndex ON\n" +
                "prices(createdDateTime)\n" +
                "where _class=\"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\"\n" +
                "AND requestType = \"MigratedPriceIntentCommand\"\n" +
                "AND status = \"PENDING\"\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migrationCommandStatusIngestionSubClass_PC_SuccessIndex ON\n" +
                "prices(subClass)\n" +
                "where _class=\"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\"\n" +
                "AND requestType = \"MigratedPriceIntentCommand\"\n" +
                "AND status = \"SUCCESS\"\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migrationCommandStatusIngestionSubClass_PC_failedIndex ON\n" +
                "prices(subClass)\n" +
                "where _class=\"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\"\n" +
                "AND requestType = \"MigratedPriceIntentCommand\"\n" +
                "AND status = \"FAILED\"\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migrationCommandStatusIngestionSubClass_PC_pendingIndex ON\n" +
                "prices(subClass)\n" +
                "where _class=\"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\"\n" +
                "AND requestType = \"MigratedPriceIntentCommand\"\n" +
                "AND status = \"PENDING\"\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migrationCommandStatusIngestionCreatedDateTime_IP_SuccessIndex ON\n" +
                "prices(createdDateTime)\n" +
                "where _class=\"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\"\n" +
                "AND requestType = \"MigratedInitialBasePriceIntentCommand\"\n" +
                "AND status = \"SUCCESS\"\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migrationCommandStatusIngestionCreatedDateTime_IP_FailedIndex ON\n" +
                "prices(createdDateTime)\n" +
                "where _class=\"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\"\n" +
                "AND requestType = \"MigratedInitialBasePriceIntentCommand\"\n" +
                "AND status = \"FAILED\"\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migrationCommandStatusIngestionCreatedDateTimeMessageId_IP_FailedIndex ON\n" +
                "prices(createdDateTime,messageId)\n" +
                "where _class=\"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\"\n" +
                "AND requestType = \"MigratedInitialBasePriceIntentCommand\"\n" +
                "AND status = \"FAILED\"\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migrationCommandStatusIngestionCreatedDateTimeMessageId_IP_PendingIndex  ON\n" +
                "prices(createdDateTime,messageId)\n" +
                "where _class=\"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\"\n" +
                "AND requestType = \"MigratedInitialBasePriceIntentCommand\"\n" +
                "AND status = \"PENDING\"\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migrationCommandStatusIngestionCreatedDateTime_IP_PendingIndex ON\n" +
                "prices(createdDateTime)\n" +
                "where _class=\"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\"\n" +
                "AND requestType = \"MigratedInitialBasePriceIntentCommand\"\n" +
                "AND status = \"PENDING\"\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migrationCommandStatusIngestionSubClass_IP_SuccessIndex ON\n" +
                "prices(subClass)\n" +
                "where _class=\"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\"\n" +
                "AND requestType = \"MigratedInitialBasePriceIntentCommand\"\n" +
                "AND status = \"SUCCESS\"\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migrationCommandStatusIngestionSubClass_IP_FailedIndex ON\n" +
                "prices(subClass)\n" +
                "where _class=\"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\"\n" +
                "AND requestType = \"MigratedInitialBasePriceIntentCommand\"\n" +
                "AND status = \"FAILED\"\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());


        result = cluster.query("CREATE INDEX migrationCommandStatusIngestionSubClass_IP_PendingIndex ON\n" +
                "prices(subClass)\n" +
                "where _class=\"com.tesco.api.price.migration.domain.entity.MigrationCommandStatus\"\n" +
                "AND requestType = \"MigratedInitialBasePriceIntentCommand\"\n" +
                "AND status = \"PENDING\"\n" +
                "using GSI;");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `migrated_initialpriceintent_effectiveDateTime` ON `prices`(`effectiveDateTime`)\n" +
                "WHERE (`_class` = \"com.tesco.api.price.migration.domain.entity.MigratedInitialPriceIntent\") using GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `migrated_initialprice_effectiveDateTime` ON `prices`(`effectiveDateTime`)\n" +
                "WHERE (`_class` = \"com.tesco.api.price.domain.entity.InitialPrice\") using GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX `migrated_initialprice_Gtins_Index` ON\n" +
                "`prices`(productDSL.parameters.gtin)\n" +
                "WHERE _class ='com.tesco.api.price.migration.domain.entity.MigratedInitialPriceIntent' using GSI WITH {\"num_partition\":6};");
        System.out.println(result.rowsAsObject());




        result = cluster.query("CREATE INDEX migration_rule_subClass_gtin_class_status_failed ON `priceMigrations`(`subClass`,`gtin`) PARTITION BY HASH(META().id)\n" +
                "WHERE `status` = 'FAILED' AND `_class` = 'com.tesco.api.price.migration.domain.model.RulesValidationResult'\n" +
                "USING GSI WITH {\"num_replica\": 1,\"num_partition\":1};\n");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migration_rule_subClass_tpnb_class_status_failed ON `priceMigrations`(`subClass`,`tpnb`) PARTITION BY HASH(META().id)\n" +
                "WHERE `status` = 'FAILED' AND `_class` = 'com.tesco.api.price.migration.domain.model.RulesValidationResult'\n" +
                "USING GSI WITH {\"num_replica\": 1,\"num_partition\":1};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migration_rule_tpnb_class ON `priceMigrations`(`tpnb`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.model.RulesValidationResult'\n" +
                "USING GSI WITH {\"num_replica\": 1,\"num_partition\":1};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migration_rule_tpnb_class_status_success ON `priceMigrations`(`tpnb`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.model.RulesValidationResult' AND `status` = 'SUCCESS'\n" +
                "USING GSI WITH {\"num_replica\": 1,\"num_partition\":1};");
        System.out.println(result.rowsAsObject());

        result = cluster.query("CREATE INDEX migration_rule_tpnb_class_status_failed ON `priceMigrations`(`tpnb`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.model.RulesValidationResult' AND `status` = 'FAILED'\n" +
                "USING GSI WITH {\"num_replica\": 1,\"num_partition\":1};");
        System.out.println(result.rowsAsObject());


        result = cluster.query("CREATE INDEX migration_rule_tpnb_gtin_class_status ON `priceMigrations`(`tpnb`,`gtin`) PARTITION BY HASH(META().id)\n" +
                "WHERE `_class` = 'com.tesco.api.price.migration.domain.model.RulesValidationResult' AND `status` = 'FAILED'\n" +
                "USING GSI WITH {\"num_replica\": 1,\"num_partition\":1};");
        System.out.println(result.rowsAsObject());

*/


    }

}
