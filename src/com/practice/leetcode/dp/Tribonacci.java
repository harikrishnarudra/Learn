package com.practice.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class Tribonacci {

    Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
    public int tribonacci(int n) {
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        cache.put(n, tribonacci(n-3)+tribonacci(n-2)+tribonacci(n-1));
        return cache.get(n);
    }
    public static void main(String[] args) {
        Tribonacci tri = new Tribonacci();
        System.out.println(tri.tribonacci(0));
        System.out.println(tri.tribonacci(1));
        System.out.println(tri.tribonacci(2));
        System.out.println(tri.tribonacci(4));
        System.out.println(tri.tribonacci(25));

    }
}
