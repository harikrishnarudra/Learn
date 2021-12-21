package com.practice.leetcode.arrays;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

/**
 * 1672. Richest Customer Wealth
 * You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.
 *
 * A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.
 *
 * Example 1:
 *
 * Input: accounts = [[1,2,3],[3,2,1]]
 * Output: 6
 * Explanation:
 * 1st customer has wealth = 1 + 2 + 3 = 6
 * 2nd customer has wealth = 3 + 2 + 1 = 6
 * Both customers are considered the richest with a wealth of 6 each, so return 6.
 */
public class MaximumWealth {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        int banks  = accounts.length;
        for(int i=0; i< banks;i++){
            int[] indWealth = accounts[i];
            int reduce = Arrays.stream(indWealth).reduce((x, y) -> x + y).getAsInt();
            if(reduce >maxWealth){
                maxWealth = reduce;
            }
        }
        return maxWealth;
    }

    /**
     * Streams one above took 2ms for run test case whereas the below one got with zero ms even after submitting.
     */

    public int maximumWealth2(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        int persons = accounts.length;
        int banks = accounts[0].length;
        for(int i=0; i<persons;i++){
            int sum = 0;
            for(int j=0;j<banks;j++){
                sum += accounts[i][j];
            }
            if (sum > maxWealth) {
                maxWealth = sum;
            }
        }
        return maxWealth;
    }

    /**
     * It took 1 ms. Overall 2 ms. Seems streams has got an overhead here for smaller data set.
     * @param accounts
     * @return
     */
    public int maximumWealth3(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        int persons = accounts.length;
        for (int i = 0; i < persons; i++) {
            int sum = Arrays.stream(accounts[i]).sum();
            if (sum > maxWealth) {
                maxWealth = sum;
            }
        }
        return maxWealth;
    }

    /**
     * Took 2 ms. It took overall 3 ms since seems overhead is more here.
     * @param accounts
     * @return
     */
    public int maximumWealth4(int[][] accounts) {
        return Arrays.stream(accounts)
                .mapToInt(custAccount -> Arrays.stream(custAccount).sum())
                .max()
                .getAsInt();
    }


    public static void main(String[] args) {
        MaximumWealth m = new MaximumWealth();
        System.out.println(m.maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));
        System.out.println(m.maximumWealth(new int[][]{{1, 5},{7,3}, { 3, 5}}));
        System.out.println(m.maximumWealth(new int[][]{{2, 8, 7},{7, 1, 3},{1, 9, 5}}));
    }
}
