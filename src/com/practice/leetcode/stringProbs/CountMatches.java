package com.practice.leetcode.stringProbs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1773. Count Items Matching a Rule
 * You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.
 * The ith item is said to match the rule if one of the following is true:
 *
 * ruleKey == "type" and ruleValue == typei.
 * ruleKey == "color" and ruleValue == colori.
 * ruleKey == "name" and ruleValue == namei.
 * Return the number of items that match the given rule.
 *
 * Example 1:
 *
 * Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 * Output: 1
 * Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
 * Example 2:
 *
 * Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
 * Output: 2
 * Explanation: There are only two items matching the given rule, which are ["phone","blue","pixel"] and ["phone","gold","iphone"]. Note that the item ["computer","silver","phone"] does not match.
 */
public class CountMatches {
    public int countMatches2(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = this.getIndex(ruleKey);
        return items.stream()
                .filter(indItem -> indItem.get(index).equalsIgnoreCase(ruleValue))
                .collect(Collectors.toList())
                .size();
    }
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        int index = getIndex(ruleKey);
        for(List<String> l : items){
            if(l.get(index).equalsIgnoreCase(ruleValue)){
                res ++;
            }
        }
        return res;
    }
    private int getIndex(final String ruleKey){
        int ind = -1;
        switch (ruleKey){
            case "type" :
                ind = 0;
                break;
            case "color":
                ind = 1;
                break;
            case "name":
                ind = 2;
                break;
            default:
                ind = -1;
        }
        return ind;
    }

    public static void main(String[] args) {
        CountMatches c = new CountMatches();
        List<List<String>> lists = Arrays.asList(Arrays.asList("phone", "blue", "pixel"), Arrays.asList("computer", "silver", "phone"),
                Arrays.asList("phone", "gold", "iphone"));
        System.out.println(c.countMatches2(lists, "type", "phone"));

        List<List<String>> lists2 = Arrays.asList(Arrays.asList("phone", "blue", "pixel"), Arrays.asList("computer", "silver", "phone"),
                Arrays.asList("phone", "gold", "iphone"));
        System.out.println(c.countMatches2(lists2, "color", "silver"));

        System.out.println(c.countMatches2(lists2, "color", "silver2"));
    }
}
