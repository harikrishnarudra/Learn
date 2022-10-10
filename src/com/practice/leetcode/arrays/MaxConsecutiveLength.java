package com.practice.leetcode.arrays;

import java.util.Arrays;

public class MaxConsecutiveLength {

    private int maxLengthConsecutive(int[] nums) {
        int maxLength = -1;
        if (nums.length < 1) {
            maxLength = 0;
        } else if (nums.length == 1) {
            maxLength = 1;
        } else {
            Arrays.sort(nums);
            int prev = nums[0], firstInd = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != prev + 1) {
                    if (maxLength < i - firstInd) {
                        maxLength = i - firstInd;
                    }
                    firstInd = i;
                } else {
                    prev = nums[i];
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        MaxConsecutiveLength s = new MaxConsecutiveLength();
        System.out.println(s.maxLengthConsecutive(new int[]{6, 13, 5, 8, 7, 4, 22, 11, 99, 55}));
    }
}
