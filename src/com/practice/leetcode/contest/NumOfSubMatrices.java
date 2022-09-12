package com.practice.leetcode.contest;

import java.util.Arrays;

public class NumOfSubMatrices {
    public int numSubmat(int[][] mat) {
        int M = mat.length, N=mat[0].length;
        int res = 0;
        for(int i = 0; i< M; i++){
            int[] h = new int[N];
            Arrays.fill(h,1);
            for(int j=i; j< M; j++){
                for(int k=0;k<N;k++){
                    h[k] &= mat[j][k];
                }
                res +=  countOneRow(h);
            }
        }
        return res;
    }

    private int countOneRow(int[] A) {
        int res=0, length = 0;
        for(int i=0; i< A.length; i++){
            length = (A[i]==0 ? 0 : length+1);
            res += length;
        }
        return res;
    }

    public static void main(String[] args) {
        NumOfSubMatrices n = new NumOfSubMatrices();
        System.out.println(n.numSubmat(new int[][]{{1,0,1},{1,1,0},{1,1,0}}));
    }

}
