package Interviews.airbnb;

import com.couchbase.client.core.deps.org.jctools.maps.NonBlockingHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Result {
    public static List<String> costOfNodes(List<String> lines){
        Map<String, List<String>> parentMap  = new HashMap<>();
        for(String line:lines){
            String[] splits = line.split(",");
            String firstChar = splits[0];
            for(int i=1;i< splits.length;i++){
                String eachSplit = splits[i];
                if(parentMap.containsKey(eachSplit)){
                    List<String> parents = parentMap.get(eachSplit);
                    parents.add(firstChar);
                    parentMap.put(eachSplit, parents);
                }else{
                    List<String> parents = new ArrayList<>();
                    parents.add(firstChar);
                    parentMap.put(eachSplit, parents);
                }
            }
        }
        List<String> result = new ArrayList<>();
        Set<String> children = parentMap.keySet();
        for(String c:children){
            String res = c;
            res+=String.valueOf(findVal(c, parentMap.get(c), parentMap));
            result.add(res);
        }
        return result;
    }

    public static int findVal(String child, List<String> parents, Map<String, List<String>> parentMap){
        Map<String,Integer> valueMap = new HashMap<>();
        for(String p:parents){
            if(valueMap.containsKey(p)){
                return valueMap.get(p);
            }
            else{
                return 1;
            }
        }
        return 0;
    }

}
