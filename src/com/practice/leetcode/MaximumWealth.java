package com.test.leetcode;

import java.util.Arrays;

//1672. Richest Customer Wealth
public class MaximumWealth {
    public int maximumWealth(int[][] accounts) {
        int wealth = 0;
        for(int i=0;i< accounts.length;i++){
            int totalAmt = Arrays.stream(accounts[i]).sum();
            //int totalAmt = this.sumOfArray(accounts[i]);
            if (totalAmt > wealth){
                wealth = totalAmt;
            }
        }
        return wealth;
    }
    private int sumOfArray(int[] arr){
        return Arrays.stream(arr).sum();
    }

    public static void main(String[] args) {
        MaximumWealth maximumWealth = new MaximumWealth();
//        int[][] arg = {{1, 5}, {1, 6}, {7, 3}};
        //int[][] arg = {{1,2,3},{3,2,1}};
        int[][] arg = {{}};
        System.out.println(maximumWealth.maximumWealth(arg));
    }


}
