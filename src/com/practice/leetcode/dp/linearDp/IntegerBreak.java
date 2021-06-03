package com.test.leetcode.dp.linearDp;

import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

/**
 * 343. Integer Break
 * Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
 *
 * Return the maximum product you can get.
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 *
 * Input: n = 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        int dp[] = new int[6];
        if (n > 6) {
            dp =new int[n + 1];
        }
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        for(int k=7;k<=n;k++){
            dp[k] = 3 * dp[k - 3];
            /*if(k%3==0){
                dp[k] = 3*dp[k-3];
//                dp[k] = calculateRecursively(k, 3);
            }
            else if(k%4==0){
                dp[k] = 4 * dp[k - 4];
//                dp[k] = calculateRecursively(k, 4);
            }
            else{
                int factor = dp[k-4];
                if(dp[k-4]<k-4){
                    factor=k-4;
                }
                dp[k] = 4*factor;
            }*/
        }
        for(int i=0;i<dp.length;i++){
            System.out.println(i+" is "+dp[i]);
        }
        return dp[n];
    }

    public int calculateRecursively(int val, int factor){
        int result = 1;
        while (val!=0){
            result *= factor;
            val -= factor;
        }
        return result;
    }

    public static void main(String[] args) {
        IntegerBreak integerBreak = new IntegerBreak();
        long startTime = System.currentTimeMillis();
        System.out.println("result is "+integerBreak.integerBreak(51));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

    }
}
