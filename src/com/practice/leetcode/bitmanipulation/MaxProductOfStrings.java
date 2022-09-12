package com.practice.leetcode.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

public class MaxProductOfStrings {

    public int bitNumber(char ch){
        return (int)ch - (int)'a';
    }

    public boolean noCommonLetters(String s1, String s2){
        int bitmask1 = 0, bitmask2 = 0;
        for(char ch:s1.toCharArray()){
            int lsb = 1 << bitNumber(ch);
            bitmask1 |= lsb;
        }
        for (char ch : s2.toCharArray()) {
            int lsb = 1 << bitNumber(ch);
            bitmask2 |= lsb;
        }
        return (bitmask1 &  bitmask2) == 0;
    }

    public int maxProd(String[] words){
        int n= words.length;
        int maxProd = 0;
        for(int  i=0;i<n;i++){
            for(int j=i+1; j<n; j++){
                if (noCommonLetters(words[i], words[j])) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }

    public int maxProd2(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        int[] lens = new int[n];
        for(int i=0;i<n;i++){
            String w = words[i];
            int bitmask = 0;
            for(char ch:w.toCharArray()){
                bitmask |= 1 << bitNumber(ch);
            }
            masks[i] = bitmask;
            lens[i] = w.length();
        }

        int maxProd = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if((masks[i] &   masks[j]) == 0){
                    maxProd = Math.max(maxProd, lens[i] * lens[j]);
                }
            }
        }
        return maxProd;
    }

    public int maxProdWithHashMap(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String w = words[i];
            int bitmask = 0;
            for (char ch : w.toCharArray()) {
                bitmask |= 1 << bitNumber(ch);
            }
            map.put(bitmask, Math.max(map.getOrDefault(bitmask, 0), w.length()));
        }

        int maxProd = 0;
        for (int i:map.keySet()) {
            for (int j :map.keySet()) {
                if ((i & j) == 0) {
                    maxProd = Math.max(maxProd, map.get(i) * map.get(j));
                }
            }
        }
        return maxProd;
    }

    public static void main(String[] args) {
        MaxProductOfStrings m = new MaxProductOfStrings();
        String[] words = new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(m.maxProd(words));
        System.out.println(m.maxProd2(words));
        System.out.println(m.maxProdWithHashMap(words));
    }
}
