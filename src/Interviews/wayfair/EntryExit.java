package Interviews.wayfair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EntryExit {
    Map<String, Integer> actionMap;

    public EntryExit(){
        actionMap = new HashMap<>();
        actionMap.put("entry", 0);
        actionMap.put("exit", 1);
    }

    public List<Set<String>> entryExits(String[][] array){
        Map<String, Integer> map = new HashMap<>();
        Set<String> missingEntries = new HashSet<>();
        Set<String> missingExits = new HashSet<>();
        for(int i=0;i<array.length;i++){
            String[] arr = array[i];
            String name = arr[0].toLowerCase();
            String action = arr[1].toLowerCase();
            if(map.containsKey(name)){
                Integer existingEntry = map.get(name);
                if((existingEntry ^ actionMap.get(action))==1){
                    map.put(name, actionMap.get(action));
                }else{
                    if(existingEntry == 0){
                        missingExits.add(name);
                    }else{
                        missingEntries.add(name);
                    }
                    map.put(name, actionMap.get(action));
                }
            }else{
                if(actionMap.get(action)==1){
                    missingEntries.add(name);
                }
                map.put(name, actionMap.get(action));
            }
        }
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(entry.getValue()==0){
                missingExits.add(entry.getKey());
            }
        }
        return List.of(missingEntries, missingExits);
    }


    /**
     *
     * My code
     */
    public List<List<String>> badgeRecords(String[][] arr) {
        List<String> entryMissing = new ArrayList();
        List<String> exitMissing = new ArrayList();
        Map<String, String> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            String[] entryArray = arr[i];
            String name = entryArray[0];
            String action = entryArray[1];
            if (map.containsKey(name)) {
                if (!action.equalsIgnoreCase(map.get(name))) {
                    map.put(name, action);
                } else {
                    if (action.equalsIgnoreCase("Entry")) {
                        exitMissing.add(name);
                    } else {
                        entryMissing.add(name);
                    }
                }
            } else {
                if (action.equalsIgnoreCase("Entry")) {
                    map.put(name, action);
                } else {
                    entryMissing.add(name);
                    map.put(name, action);
                }
            }
        }
        return List.of(entryMissing, exitMissing);
    }


    public static void main(String[] args) {
        EntryExit e = new EntryExit();
        String[][] arr = new String[][]{{"Martha", "Exit"},
                {"Paul", "Entry"},
                {"Thomas", "Entry"},
                {"Martha", "Entry"},
                {"Paul", "Exit"},
                {"Thomas", "Entry"},
                {"Paul", "Exit"}
        };
        List<Set<String>> entries = e.entryExits(arr);
        System.out.println(entries);

    }

}
