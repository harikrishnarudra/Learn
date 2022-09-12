package com.practice.leetcode.interviewExperience;

import java.util.Arrays;

public class PickApples {

    public int pickApples(int[] a, int k, int l) {
        int len = a.length;
        if(len < k+l){
            return -1;
        }
        if(len == k+l) {
            return Arrays.stream(a).sum();
        }
        //Create a dp array
        int[] dp = new int[len];
        dp[0] = a[0];
        for(int i=1;i<len;i++){
            dp[i] = dp[i-1]+a[i];
        }

        int maxSum = 0;
        for(int iStart = 0; iStart<len-k+1; iStart++){
            int iEnd = iStart+k-1;
            for(int jStart = 0; jStart<len-l+1; jStart++){
                int jEnd = jStart+l-1;
                if(jStart > iEnd){
                    int iSum = getSum(dp, iStart, iEnd);
                    int jSum = getSum(dp, jStart, jEnd);
                    maxSum = Math.max(maxSum, iSum+jSum);
                }
            }
        }
        return maxSum;
    }

    private int getSum(int[] dp, int start, int end){
        int prev = 0;
        if(start > 0){
            prev = dp[start-1];
        }
        return dp[end]-prev;
    }

    public static void main(String[] args) {
        PickApples p = new PickApples();
        System.out.println(p.pickApples(new int[]{6,1,4,6,3,2,7,4}, 3, 2));
        System.out.println(p.pickApples(new int[]{10, 19, 15}, 2, 2));
    }
}
