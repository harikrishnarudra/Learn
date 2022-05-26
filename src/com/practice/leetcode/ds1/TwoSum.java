package com.practice.leetcode.ds1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.

 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */

/**
 * 1. We can do with either 2 For loops - Simple brute force approach OR
 * 2. Use a map to save the required target elements
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int element = nums[i];
            if(map.keySet().contains(element)){
                return new int[]{map.get(element), i};
            }
            else {
                map.put(target - element, i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] res = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        res = twoSum.twoSum(new int[]{3, 7, 11, 15, 1, 8}, 9);
        Arrays.stream(res).forEach(System.out::println);

        res = twoSum.twoSum(new int[]{3, 2, 4}, 6);
        Arrays.stream(res).forEach(System.out::println);

        res = twoSum.twoSum(new int[]{3, 3}, 6);
        Arrays.stream(res).forEach(System.out::println);

        res = twoSum.twoSum(new int[]{0, 3, 3, 0}, 0);
        Arrays.stream(res).forEach(System.out::println);

        res = twoSum.twoSum(new int[]{-3, 4, 3, 90}, 0);
        Arrays.stream(res).forEach(System.out::println);
    }
}
