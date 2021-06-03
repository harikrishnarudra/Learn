package com.practice.leetcode.dp.linearDp;

/**
 * 279. Perfect Squares
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class PerfectSquares {

    public int numSquares(int n) {
        if(n>0){
            int[] dp = new int[n+1];
            for(int i=0;i<=n;i++){
                dp[i] = i;
            }
            for(int i=2;i<=n;i++){
                for(int j=1; (i-(j*j))>=0; j++){
                    dp[i] = Math.min(dp[i], dp[i-j*j]+1);
                }
            }
            return dp[n];
        }
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(new PerfectSquares().numSquares(35));
        double val = 20.0;
        int f = 10;
        double res = f / 100.0 + val;
        System.out.println(res);
    }
}
