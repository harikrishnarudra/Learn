package com.practice.leetcode.dp;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        for(int i:nums){
            maxEndingHere += i;
            maxEndingHere = Math.max(maxEndingHere, i);
            maxSum = Math.max(maxSum, maxEndingHere);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray.maxSubArray(new int[]{-2, -1, -3, -4, -1, -2, -1, -5, -4}));
        System.out.println(maxSubArray.maxSubArray(new int[]{1}));
        System.out.println(maxSubArray.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
