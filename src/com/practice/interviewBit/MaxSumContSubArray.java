package com.practice.interviewBit;

import java.util.Arrays;

/**
 * Find the contiguous subarray within an array, A of length N which has the largest sum.
 * Input Format:
 * The first and the only argument contains an integer array, A.
 * Output Format:
 * Return an integer representing the maximum possible sum of the contiguous subarray.
 *
 * Constraints:
 * 1 <= N <= 1e6
 * -1000 <= A[i] <= 1000
 * For example:
 *
 * Input 1:
 *     A = [1, 2, 3, 4, -10]
 *
 * Output 1:
 *     10
 *
 * Explanation 1:
 *     The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
 *
 * Input 2:
 *     A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 *
 * Output 2:
 *     6
 *
 * Explanation 2:
 *     The subarray [4,-1,2,1] has the maximum possible sum of 6.
 */
public class MaxSumContSubArray {
    public int maxSubArray(final int[] A) {
        if(A==null){
            return 0;
        }
        int sumVal = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<A.length;i++){
            sumVal += A[i];
            if(sumVal > maxSum){
                maxSum = sumVal;
            }
            if(sumVal < 0){
                sumVal = 0;
            }
        }
        return maxSum;
    }

    public int[] maxSubArrayWithRange(final int[] A) {
        if (A == null) {
            return new int[]{0,0,0};
        }
        int startInd = 0, endInd = 0, s = 0, sumVal = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            sumVal += A[i];
            if (sumVal > maxSum) {
                maxSum = sumVal;
                startInd = s;
                endInd = i;
            }
            if (sumVal < 0) {
                sumVal = 0;
                s = i + 1;
            }
        }
        return new int[]{maxSum, startInd, endInd};
    }

    public static void main(String[] args) {
        MaxSumContSubArray m = new MaxSumContSubArray();
        System.out.println(m.maxSubArray(new int[]{1, 2, 3, 4, -10}));
        System.out.println("----");
        System.out.println(m.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

        System.out.println("----");
        Arrays.stream(m.maxSubArrayWithRange(new int[]{1, 2, 3, 4, -10})).forEach(System.out::println);
        System.out.println("----");
        Arrays.stream(m.maxSubArrayWithRange(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})).forEach(System.out::println);
    }
}
