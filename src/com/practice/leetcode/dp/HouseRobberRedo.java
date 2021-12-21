package com.practice.leetcode.dp;

public class HouseRobberRedo {

    public int rob(int[] profit){
        if(profit!=null && profit.length>0){
            int leng = profit.length;
            if (leng == 1) return profit[0];
            if (leng == 2) return Math.max(profit[0], profit[1]);
            for(int i=2; i<leng;i++){
                profit[i] = maxProfit(profit, 0, i);
            }
            return Math.max(profit[leng-1], profit[leng-2]);
        }
        return 0;
    }

    private int maxProfit(int[] profit, int start, int end){
        if (end-3 < 0) return profit[end]+profit[start];
        return profit[end] + Math.max(profit[end-2], profit[end-3]);
    }

    public int rob2(int[] profit) {
        if (profit != null && profit.length > 0) {
            int leng = profit.length;
            if (leng == 1) return profit[0];
            if (leng == 2) return Math.max(profit[0], profit[1]);
            for (int i = 2; i < leng; i++) {
                if (i - 3 < 0) {
                    profit[i] += profit[0];
                }
                else {
                    profit[i] += Math.max(profit[i - 2], profit[i - 3]);
                }
            }
            return Math.max(profit[leng - 1], profit[leng - 2]);
        }
        return 0;
    }

    public static void main(String[] args) {
        HouseRobberRedo houseRobberRedo = new HouseRobberRedo();
        System.out.println(houseRobberRedo.rob2(new int[]{1,2,3,1}));
        System.out.println(houseRobberRedo.rob2(new int[]{2, 7, 9, 3, 1}));
        System.out.println(houseRobberRedo.rob2(new int[]{4, 1, 1, 8, 1}));
        System.out.println(houseRobberRedo.rob2(new int[]{1}));
        System.out.println(houseRobberRedo.rob2(new int[]{1,2}));
    }
}
