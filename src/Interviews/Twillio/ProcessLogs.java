package Interviews.Twillio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessLogs {
    public static List<String> processLogs(List<String> logs, int threshold) {
        // Write your code here
        Map<String, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        String prevElem= null;
        int count=1;
        for(String log:logs){
            String[] elements = log.split(" ");
            for (int i=0;i<2;i++) {
                String element = elements[i];
                if(i==1 && prevElem!=null && prevElem.equalsIgnoreCase(element)){
                    continue;
                }
                prevElem = element;
                if(map.containsKey(element)){
                    count = map.get(element);
                    count++;
                }
                else{
                    count =1;
                }
                map.put(elements[i],count);
                if (count >= threshold && !result.contains(Integer.parseInt(element))) {
                    result.add(Integer.parseInt(element));
                }
            }
            prevElem = null;
        }
        Collections.sort(result);
        List<String> stringList = new ArrayList<>(result.size());
        for (Integer myInt : result) {
            stringList.add(String.valueOf(myInt));
        }
        return stringList;
    }

    public static void main(String[] args) {
        System.out.println(processLogs(List.of("88 99 200","88 99 300","99 32 100","12 12 15"),2));
        System.out.println(processLogs(List.of("1 2 200"), 1));
        System.out.println(processLogs(List.of("1 2 57","1 7 70","1 3 54","2 2 56"), 2));
    }

}
