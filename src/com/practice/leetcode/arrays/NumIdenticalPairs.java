package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1512. Number of Good Pairs
 * Given an array of integers nums, return the number of good pairs.
 *
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 */
public class NumIdenticalPairs {
    public int numIdenticalPairs(int[] nums) {
        int totalPairs = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])) {
                List<Integer> vals = map.get(nums[i]);
                totalPairs += vals.size();
                vals.add(i);
                map.put(nums[i], vals);
            } else {
                List<Integer> newL = new ArrayList<>();
                newL.add(i);
                map.put(nums[i], newL);
            }
        }
        return totalPairs;
    }

    /**
     * I Liked this solution. Simple, crisp and clear
     */
    public int numIdenticalPairs2(int[] nums) {
        int ans = 0;
        int[] count = new int[101];

        for (int n : nums)
            count[n]++;

        for (int n : count)
            ans += (n * (n - 1)) / 2;  //Seems like Npr permutation formula

        return ans;
    }

    public static void main(String[] args) {
        NumIdenticalPairs n = new NumIdenticalPairs();
        System.out.println(n.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println(n.numIdenticalPairs(new int[]{1, 1, 1, 1}));
        System.out.println(n.numIdenticalPairs(new int[]{1, 2, 3}));
    }
}
