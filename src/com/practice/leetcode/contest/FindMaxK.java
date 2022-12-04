package com.practice.leetcode.contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindMaxK {
    public int findMaxK(int[] nums) {
        int max = -1;
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            if(i<0){
                set.add(i);
            }
        }
        for(int i:nums){
            if(i>0 && set.contains(-i)){
                max = Math.max(max, i);
            }
        }
        return max;
    }

    public int findMaxKVerbose(int[] nums) {
        int maxK = -1;
        Map<Integer, String> map = new HashMap<>();
        String sign = "";
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0){
                sign = "NEGATIVE";
            }else{
                sign = "POSITIVE";
            }
            int y = Math.abs(nums[i]);
            if (map.containsKey(y) && !map.get(y).equalsIgnoreCase(sign)) {
                if (y > maxK) {
                    maxK = y;
                }
            } else {
                map.put(y, sign);
            }
        }
        return maxK;
    }

    public static void main(String[] args) {
        FindMaxK f = new FindMaxK();
        System.out.println(f.findMaxK(new int[]{-10, 8, 6, 7, -2, -3}));
        System.out.println(f.findMaxK(new int[]{-1, 10, 6, 7, -7, 1}));
        System.out.println(f.findMaxK(new int[]{-1, 2, -3, 3}));
        System.out.println(f.findMaxK(new int[]{-9, -43, 24, -23, -16, -30, -38, -30}));
    }
}
