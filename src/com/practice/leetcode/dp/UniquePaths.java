package com.practice.leetcode.dp;

import org.springframework.data.util.Pair;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class UniquePaths {

    public int uniquePaths3(int m, int n) {
        int[][] mnCache = new int[m][n];
        return uniquePaths3Helper(m-1,n-1, mnCache);
    }

    public int uniquePaths3Helper(int m, int n, int[][] mnCache) {
        if (m < 0 || n < 0) return 0;
        if (m == 0 || n == 0) return 1;
        if(mnCache[m][n] > 0){
            return mnCache[m][n];
        }
        int ans = uniquePaths3Helper(m - 1, n, mnCache) + uniquePaths3Helper(m, n - 1, mnCache);
        mnCache[m][n] = ans;
        return mnCache[m][n];
    }


    Map<Map.Entry<Integer, Integer>, Integer> cache = new HashMap();

    public int uniquePaths2(int m, int n) {
        AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(m, n);
        if(cache.containsKey(simpleEntry)){
            return cache.get(simpleEntry);
        }
        if (m < 2 || n < 2) return 1;
        int ans= uniquePaths2(m - 1, n )+ uniquePaths2(m, n - 1);
        cache.put(simpleEntry, ans);
        return cache.get(simpleEntry);
    }

    Map<Pair<Integer, Integer>, Integer> pairCache = new HashMap();

    public int uniquePaths(int m, int n) {
        if(m<2 && n <2) return 1;
        return recurse(0,0,m-1,n-1);
    }
    private int recurse(int row, int col, int m, int n){
        if(pairCache.containsKey(Pair.of(row,col))){
            return pairCache.get(Pair.of(row, col));
        }
        if(row == m || col == n) return 1;
        int result = recurse(row + 1, col, m, n) + recurse(row, col + 1, m, n);
        pairCache.put(Pair.of(row, col), result);
        return result;
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths3(3, 3));
        System.out.println(uniquePaths.uniquePaths3(7, 3));
        System.out.println(uniquePaths.uniquePaths3(3, 2));
        System.out.println(uniquePaths.uniquePaths3(2, 2));
        System.out.println(uniquePaths.uniquePaths3(3, 7));
        System.out.println(uniquePaths.uniquePaths3(7,3));
        System.out.println(uniquePaths.uniquePaths3(0, 0));
        System.out.println(uniquePaths.uniquePaths3(0, 1));
        System.out.println(uniquePaths.uniquePaths3(1, 0));
        System.out.println(uniquePaths.uniquePaths3(1, 1));
        System.out.println(uniquePaths.uniquePaths3(1, 2));
        System.out.println(uniquePaths.uniquePaths3(2, 1));
    }
}
