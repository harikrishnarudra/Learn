package com.practice.leetcode.contest;

public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        int res = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] trans = this.transposeM(grid, rows, cols);

        for (int i = 0; i < rows; i++) {
            for(int j=0; j < rows; j++){
                if (match(grid[i], trans[j])) {
                    res += 1;
                }
            }

        }
        return res;
    }

    private int[][] transposeM(int[][] grid, int rowSize, int colSize) {

        int[][] transpose = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                transpose[j][i] = grid[i][j];
            }
        }
        return transpose;
    }

    private boolean match(int[] first, int[] sec) {
        boolean isMatch = true;
        for (int i = 0; i < first.length; i++) {
            if (first[i] != sec[i]) {
                isMatch = false;
                break;
            }
        }
        return isMatch;
    }

    public static void main(String[] args) {
        int[][] grid = {{3, 2, 1},{1, 7, 6},{2, 7, 7}};
        EqualRowAndColumnPairs e = new EqualRowAndColumnPairs();
        System.out.println(e.equalPairs(grid));
    }
}
