package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumObstacles {
    Map<String, Integer> map = new HashMap<>();
    public int minimumObstacles(int[][] grid) {
        return recurse(grid, 0, 0, grid.length, grid[0].length);
    }

    private int recurse(int[][] grid, int i, int j, int m, int n){
        if(map.containsKey(i+""+j)){
            return map.get(i + "" + j);
        }
        int left=Integer.MAX_VALUE, right=Integer.MAX_VALUE, result = -1;
        if(i+1 < m){
            left = recurse(grid, i+1, j, m, n);
        }
        if (j + 1 < n) {
            right = recurse(grid, i , j+1, m, n);
        }
        result = Math.min(left, right)+ grid[i][j];
        map.put(i + "" + j, result);
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        MinimumObstacles m = new MinimumObstacles();
        int[][] arr = new int[][]{{0,1,0},{0,1,0},{0,0,0}};
//        System.out.println("Final result: "+ m.minimumObstacles(arr));

        arr = new int[][]{{0}};
//        System.out.println("Final result: " + m.minimumObstacles(arr));

        arr = new int[][]{{0, 1, 1, 1, 0}};
        System.out.println("Final result: " + m.minimumObstacles(arr));
    }
}
