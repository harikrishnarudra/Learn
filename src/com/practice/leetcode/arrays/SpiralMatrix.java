package com.practice.leetcode.arrays;

public class SpiralMatrix {

    public void spiralMatrix(int m, int n, int[][] result) {
        boolean[][] seen = new boolean[m][n];
        for (int i = 0, j, k; i < (m + 1) / 2; i++) {
            for (j = i, k = i; k < n - i && !seen[j][k]; k++) {
                System.out.print(result[j][k]);
                seen[j][k] = true;
                System.out.print(" ");
            }
            System.out.println();
            for (j++, k--; j < m - i && !seen[j][k]; j++) {
                System.out.print(result[j][k]);
                seen[j][k] = true;
                System.out.print(" ");
            }
            System.out.println();
            for (j--, k--; k >= i && !seen[j][k]; k--) {
                System.out.print(result[j][k]);
                seen[j][k] = true;
                System.out.print(" ");
            }
            System.out.println();
            for (j--, k++; j > i && !seen[j][k]; j--) {
                System.out.print(result[j][k]);
                seen[j][k] = true;
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        int[][] ints = new int[][]{{3, 0, 2, 6, 8}, {1, 7, 9, 4, 2}, {5, 5, 0, 6, 7}};
        s.spiralMatrix(3, 5, ints);
    }
}
