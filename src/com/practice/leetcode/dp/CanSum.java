package com.test.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class CanSum {

    private boolean canSum (int targetSum, int[] array, Map<Integer, Boolean> map){
        if (map.containsKey(targetSum)) return map.get(targetSum);
        if (targetSum ==0 ) return  true;
        if (targetSum < 0) return false;

        for (int i: array) {
            int remainder = targetSum - i;
            if (canSum(remainder,array, map)==true){
                map.put(targetSum, true);
                return true;
            }
        }
        map.put(targetSum, false);
        return false;
    }

    public static void main(String[] args) {
        CanSum canSum = new CanSum();
        System.out.println(canSum.canSum(7, new int[]{2,3}, new HashMap<Integer, Boolean>()));
        System.out.println(canSum.canSum(7, new int[]{5,3,4,7}, new HashMap<Integer, Boolean>()));
        System.out.println(canSum.canSum(7, new int[]{2,4}, new HashMap<Integer, Boolean>()));
        System.out.println(canSum.canSum(7, new int[]{2,4,5}, new HashMap<Integer, Boolean>()));
        System.out.println(canSum.canSum(300, new int[]{7,14}, new HashMap<Integer, Boolean>()));
    }
}
