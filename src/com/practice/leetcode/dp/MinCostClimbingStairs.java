package com.practice.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs {
    Map<Integer, Integer> cache = new HashMap<>();
    public int minCostClimbingStairs(int n, int[] cost) {
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        if(n<0) return 0;
        int ans = 0;
        int subAns= Math.min(minCostClimbingStairs(n-1, cost), minCostClimbingStairs(n- 2, cost));
        if( n < cost.length) {
            ans = cost[n] + subAns;
        }else{
            ans = subAns;
        }
        cache.put(n, ans);
        return cache.get(n);
    }

    public int dp(int[] cost){
        for(int i=2;i<cost.length;i++){
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }
        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }

    public static void main(String[] args) {
//        int[] c = new int[]{10,15,20};
        int [] c = new int[]{ 1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(c.length);
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
//        System.out.println(minCostClimbingStairs.minCostClimbingStairs(c.length, c));
        System.out.println(minCostClimbingStairs.dp(c));
    }

}
