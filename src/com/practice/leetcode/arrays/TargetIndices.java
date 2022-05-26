package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 2089. Find Target Indices After Sorting Array
 * You are given a 0-indexed integer array nums and a target element target.
 * A target index is an index i such that nums[i] == target.
 * Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices, return an empty list. The returned list must be sorted in increasing order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,5,2,3], target = 2
 * Output: [1,2]
 * Explanation: After sorting, nums is [1,2,2,3,5].
 * The indices where nums[i] == 2 are 1 and 2.
 * Example 2:
 *
 * Input: nums = [1,2,5,2,3], target = 3
 * Output: [3]
 * Explanation: After sorting, nums is [1,2,2,3,5].
 * The index where nums[i] == 3 is 3.
 * Example 3:
 *
 * Input: nums = [1,2,5,2,3], target = 5
 * Output: [4]
 * Explanation: After sorting, nums is [1,2,2,3,5].
 * The index where nums[i] == 5 is 4.
 */
public class TargetIndices {

    /**
     * Seems best possible way. Find out the count of lowered valued numbers and also count of target numbers
     * in one loop
     * @param nums
     * @param target
     * @return
     */
    public List<Integer> targetIndices(int[] nums, int target) {
        int countOfTargets = 0;
        int countOfLessThanTargets = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                countOfTargets++;
            }
            if(nums[i]<target){
                countOfLessThanTargets++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=countOfLessThanTargets; i<countOfLessThanTargets+countOfTargets;i++){
            res.add(i);
        }
        return res;
    }

    public List<Integer> targetIndices2(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        int effIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>target){
                effIndex++;
            }
            if (nums[i] == target) {
                int m = 0;
                int p = i+1;
                for(;p<nums.length;p++){
                    if(nums[p] < target){
                        m++;
                    }
                }
                res.add(i - effIndex+m);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TargetIndices t = new TargetIndices();
        List<Integer> res = t.targetIndices(new int[]{1, 2, 5, 2, 3}, 2);
        res.forEach(System.out::println);
        System.out.println("=======");
        res = t.targetIndices(new int[]{1, 2, 2, 3, 5}, 3);
        res.forEach(System.out::println);
        System.out.println("=======");
        res = t.targetIndices(new int[]{1, 2, 2, 3, 5}, 5);
        res.forEach(System.out::println);
        System.out.println("=======");
        res = t.targetIndices(new int[]{1, 2, 2, 3, 5}, 6);
        res.forEach(System.out::println);
        System.out.println("=======");
        res = t.targetIndices(new int[]{1, 2, 5, 2, 3}, 5);
        res.forEach(System.out::println);
        System.out.println("=======");
        res = t.targetIndices(new int[]{1, 2, 7, 5, 6, 2, 3}, 5);
        res.forEach(System.out::println);
        System.out.println("=======");
        res = t.targetIndices(new int[]{1, 2, 7, 5, 6, 2, 3}, 7);
        res.forEach(System.out::println);
        System.out.println("=======");
        res = t.targetIndices(new int[]{100, 1,100}, 100);
        res.forEach(System.out::println);
    }
}
