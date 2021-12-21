package com.practice.leetcode.arrays;

import java.util.Arrays;

/**
 * 1470. Shuffle the Array
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 *
 * Example 1:
 *
 * Input: nums = [2,5,1,3,4,7], n = 3
 * Output: [2,3,5,4,1,7]
 * Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
 */
public class ShuffleArray {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2*n];
/*        int j=0;
        for (int i = 0; i < n; i++) {
            result[j++] = nums[i];
            result[j++] = nums[i+n];
        }*/
        for(int i=0,j=0;i<n;i++,j++){
            result[j++] = nums[i];
            result[j] = nums[i+n];
        }
        return result;
    }

    public static void main(String[] args) {
        ShuffleArray shuffleArray = new ShuffleArray();
        int[] res = shuffleArray.shuffle(new int[]{2, 5, 1, 3, 4, 7},3);
        Arrays.stream(res).forEach(System.out::println);
    }
}
