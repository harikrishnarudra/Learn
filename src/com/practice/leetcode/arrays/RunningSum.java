package com.practice.leetcode.arrays;

import java.util.Arrays;

/**
 * 1480. Running Sum of 1d Array
 *
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 *
 * Return the running sum of nums.
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 */
public class RunningSum {
    public int[] runningSum(int[] nums) {
        int x=0;
        for(int i=0;i<nums.length;i++){
            nums[i] += x;
            x = nums[i];
        }
        return nums;
    }
    public static void main(String[] args) {
        RunningSum rs = new RunningSum();
        int[] res = rs.runningSum(new int[]{1,2,3,4});
        Arrays.stream(res).forEach(System.out::println);
    }
}
