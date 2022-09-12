package com.practice.leetcode.contest;

import java.util.Arrays;

public class LargestLocal {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] res  = new int[n-2][m-2];
        for(int j=0;j<n-2;j++){
            for(int p=0;p<m-2;p++){
                int max = grid[j][p];
                for (int i = j; i <= j + 2; i++) {
                    for (int k = p;  k <= p + 2; k++) {
                        if (grid[i][k] > max) {
                            max = grid[i][k];
                        }
                    }
                }
                res[j][p] = max;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LargestLocal l = new LargestLocal();
        int[][] res = l.largestLocal(new int[][]{{9, 9, 8, 1},{5, 6, 2, 6},{8, 2, 6, 4},{6, 2, 2, 2}});
        for(int i=0;i< res.length;i++){
            Arrays.stream(res[i]).forEach(System.out::println);
        }

    }
}
