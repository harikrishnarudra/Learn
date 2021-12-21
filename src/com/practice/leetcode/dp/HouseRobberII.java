package com.practice.leetcode.dp;

public class HouseRobberII {

    public int rob(int[] profit){
        int leng = profit.length;
        if (leng == 1) return profit[0];
        return Math.max(rob(profit, 0, leng - 2), rob(profit, 0, leng - 1));
    }

    private int rob(int[] num,int lo,int hi){
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + num[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        HouseRobberII houseRobberII = new HouseRobberII();
        System.out.println(houseRobberII.rob(new int[]{1,2,3,1}));
        System.out.println(houseRobberII.rob(new int[]{1, 2, 3}));
        System.out.println(houseRobberII.rob(new int[]{1, 2}));
    }
}
