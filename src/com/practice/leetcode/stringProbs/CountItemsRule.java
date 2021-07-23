package com.practice.leetcode.stringProbs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountItemsRule {

    public static int countMatches2(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = -1;
        if (ruleKey.equalsIgnoreCase("type")) {
            index = 0;
        }
        else if (ruleKey.equalsIgnoreCase("color")) {
            index = 1;
        }
        else if (ruleKey.equalsIgnoreCase("name")) {
            index = 2;
        }
        int finalIndex = index;
        List<List<String>> collect = items.stream().filter(item -> item.get(finalIndex).equalsIgnoreCase(ruleValue))
                .collect(Collectors.toList());
        return collect.size();
    }

    public static int countMatches3(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = -1;
        if (ruleKey.equalsIgnoreCase("type")) {
            index = 0;
        } else if (ruleKey.equalsIgnoreCase("color")) {
            index = 1;
        } else if (ruleKey.equalsIgnoreCase("name")) {
            index = 2;
        }
        int result = 0;
        for(int i=0;i<items.size();i++){
            if(items.get(i).get(index).equalsIgnoreCase(ruleValue)){
                result++;
            }
        }
        return result;
    }

    public static int countMatches4(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = -1;
        switch (ruleKey) {
            case "type":
                index = 0;
                break;
            case "color":
                index = 1;
                break;
            case "name":
                index = 2;
                break;
        }

        int result = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).get(index).equalsIgnoreCase(ruleValue)) {
                result++;
            }
        }
        return result;
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Integer> cache= new HashMap<>();
        cache.put("type", 0);
        cache.put("color", 1);
        cache.put("name", 2);
        int result = 0;
        for (List<String> item:items) {
            if (item.get(cache.get(ruleKey)).equalsIgnoreCase(ruleValue)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countMatches(List.of(List.of("phone", "blue", "pixel"),
                List.of("computer", "silver", "lenovo"),
                List.of("phone", "gold", "iphone")), "color", "silver"));
    }
}
