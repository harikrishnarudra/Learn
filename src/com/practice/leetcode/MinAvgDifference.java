package com.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MinAvgDifference {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int prevLeftSum = 0;
        int prevRightSum = 0;
        for (int i = 0; i < n; i++) {
            prevRightSum += nums[i];
        }
        int leftDivisor = 0;
        int rightDivisor = n;
        int avg = 0, min = Integer.MAX_VALUE, result = -1;
        for (int i = 0; i < n; i++) {
            prevLeftSum += nums[i];
            prevRightSum -= nums[i];
            leftDivisor = i + 1;
            rightDivisor = n-i-1;
            int right =0;
            if(rightDivisor !=0){
                right = prevRightSum / rightDivisor;
            }else{
                right = prevRightSum / 1;
            }
            int left = prevLeftSum / leftDivisor;

            avg = Math.abs(left - right);

            if (avg < min) {
                System.out.println("index of " + i + " avg is " + avg);
                min = avg;
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinAvgDifference m = new MinAvgDifference();
        System.out.println(m.minimumAverageDifference(new int[]{2, 5, 3, 9, 5, 3}));
        
    }
}
