package com.test.leetcode.dp.linearDp;

import java.util.Arrays;

/**
 * 322. Coin Change
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 *
 *Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 * Example 4:
 *
 * Input: coins = [1], amount = 1
 * Output: 1
 * Example 5:
 *
 * Input: coins = [1], amount = 2
 * Output: 2
 *
 * https://www.youtube.com/watch?v=-NTaXJ7BBXs
 */
public class CoinChange {

    public static void main(String[] args) {
        int amount = 6249;
        int coins[] = {186, 419, 83, 408};

        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int minCoinsNeeded = coinChange(coins,amount, dp);
        System.out.println(minCoinsNeeded);
        for (int x : dp) {
            System.out.print(x+" ");
        }
    }

    /**
     * Pure Linear Dynamic programming problem with dividing the problem set into multiple subset of problems.
     * Recursively evaluating each sub problem.
     * @param coins
     * @param amount
     * @param dp
     * @return
     */
    static int coinChange(int[] coins, int amount, int[] dp) {
        if(amount ==0 ) return 0;
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<coins.length; i++){
            if(amount - coins[i] >=0) {
                int minAns = 0;
                if(dp[amount-coins[i]] != -1){
                    minAns = dp[amount - coins[i]];
                }
                else {
                    minAns = coinChange(coins, amount - coins[i], dp);
                }
                if (minAns!= Integer.MAX_VALUE && minAns+1 < ans) {
                    ans = minAns +1;
                }
            }
        }

        return dp[amount] = ans;
    }
}
