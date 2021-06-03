package com.practice.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 73. Set Matrix Zeroes
 *
 * Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Follow up:
 *
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * Example 2:
 *
 *
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */
public class SetMatrixZeros {
    public static void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        int cols = matrix[0].length;
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j< cols;j++){
                if(matrix[i][j] ==0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        System.out.println(rowSet);
        System.out.println("=======");
        System.out.println(colSet);
        for(int k=0;k<cols;k++){
            for (int l : rowSet) {
                matrix[l][k] = 0;
            }
        }
        for (int k = 0; k < matrix.length; k++) {
            for (int l:colSet) {
                matrix[k][l] = 0;
            }
        }
    }

    public static void setZeroes2(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    for(int k=0;k<rows;k++){
                        matrix[k][j]=0;
                    }
                    /*for(int k=j;k<cols;k++){
                        matrix[i][k]=0;
                    }
                    for (int k = j; k >= 0; k--) {
                        matrix[i][k] = 0;
                    }*/
                }
            }
            for (int k = 0; k < rows; k++) {
                matrix[k][i] = 0;
            }
        }
        System.out.println(rowSet);
        System.out.println("=======");
        System.out.println(colSet);
        /*for (int k = 0; k < cols; k++) {
            for (int l : rowSet) {
                matrix[l][k] = 0;
            }
        }
        for (int k = 0; k < matrix.length; k++) {
            for (int l : colSet) {
                matrix[k][l] = 0;
            }
        }*/
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0},{3, 4, 5, 2},{1, 3, 1, 5}};
//        int[][] matrix = {{1, 1, 1},{1, 0, 1},{1, 1, 1}};
        setZeroes2(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
