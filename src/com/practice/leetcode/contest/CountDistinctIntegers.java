package com.practice.leetcode.contest;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctIntegers {

    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i:nums) {
            set.add(i);
            int y= 0;
            while(i>0){
                y = y*10+i%10;
                i /= 10;
            }
            set.add(y);
        }
        return set.size();
    }

    public int countDistinctIntegersWithString(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
            StringBuilder strB = new StringBuilder();
            int y= Integer.parseInt(strB.append(nums[i]).reverse().toString());
            set.add(y);
        }
        return set.size();
    }

    public static void main(String[] args) {
        CountDistinctIntegers c = new CountDistinctIntegers();
        System.out.println(c.countDistinctIntegers(new int[]{1, 13, 10, 12, 31}));
        System.out.println(c.countDistinctIntegers(new int[]{2, 2, 2}));
    }
}
