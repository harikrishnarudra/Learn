package com.practice.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    Map<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        if(cache.containsKey(n)) return cache.get(n);
        if (n == 1) return 1;
        if (n == 2) return 2;
        cache.put(n, climbStairs(n-1)+climbStairs(n-2));
        return cache.get(n);
    }

    public static void main(String[] args) {
        ClimbStairs c = new ClimbStairs();
        System.out.println(c.climbStairs(4));
        System.out.println(c.climbStairs(3));
        System.out.println(c.climbStairs(5));
        System.out.println(c.climbStairs(2));
    }
}
