package com.practice.leetcode.contest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        int result = 0;
        Map<Integer, List<Integer>> map = new HashMap();
        for(int i:nums){
            map.put(i, List.of(i+diff, i+2*diff));
        }
        Set<Integer> keys = map.keySet();
        for(int key:keys){
            List<Integer> values = map.get(key);
            if(keys.containsAll(values)){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArithmeticTriplets a = new ArithmeticTriplets();
        System.out.println(a.arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10},3));
        System.out.println(a.arithmeticTriplets(new int[]{4, 5, 6, 7, 8, 9}, 2));
    }
}
