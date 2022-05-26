package com.practice.leetcode.arrays;

import java.util.Arrays;

public class CountKDifference {

    public int countKDifference(int[] nums, int k) {
        int res = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1; j< nums.length ; j++){
                if(nums[i] + k == nums[j] || nums[i] - k == nums[j]){
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountKDifference c = new CountKDifference();
        System.out.println(c.countKDifference(new int[]{3,2,1,5,4}, 2));
        System.out.println(c.countKDifference(new int[]{1,3}, 3));
        System.out.println(c.countKDifference(new int[]{1, 2, 2, 1}, 1));
        int[] count = new int[6];
        int[] nums = new int[]{1, 2, 2, 1, 1};
        for(int m=0; m < nums.length; m++){
            count[nums[m]]++;
        }
        Arrays.stream(count).forEach(System.out::println);
    }
}
