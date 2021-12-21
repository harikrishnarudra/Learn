package com.practice.leetcode.stringProbs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountConsistentStrings {
    public static int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        boolean isValid;
        for(String word:words){
            isValid = true;
            for(char c:word.toCharArray()){
                if(!allowed.contains(String.valueOf(c))){
                    isValid = false;
                }
            }
            if(isValid)
                count++;
        }
        return count;
    }

    public static int countConsistentStringsWithSet(String allowed, String[] words) {
        int count = words.length;
        Set<Character> set = new HashSet<>();
        for(char c:allowed.toCharArray()){
            set.add(c);
        }
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!set.contains(c)) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }

    public static int countConsistentStringsWithHashing(String allowed, String[] words) {
        int count = words.length;
        int[] chars = new int[26];
        for (char c : allowed.toCharArray()) {
            chars[c-'a']++;
        }
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (chars[c-'a']<=0) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countConsistentStringsWithHashing("ab",new String[]{"ad", "bd", "aaab", "baa", "badab"}));
    }
}
