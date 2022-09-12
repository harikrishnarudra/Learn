package com.practice.leetcode.assessment;

public class NumOfSubMatricesOfOne {

    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int result = 0;
        for(int i = 0; i<m; i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    result++;
                    int k = j+1;
                    while(k < n){
                        if(mat[i][k++] == 1){
                            result++;
                        }
                    }
                    int p = i+1;
                    while(p < m){
                        if (mat[p++][j] == 1) {
                            result++;
                        }
                    }
                    int s=i, q=j, l = i+1, r = j+1;
                    while(l<m && r <n){
                        if(mat[l][q] == 1 && mat[s][r] == 1 && mat[l][s] == 1){
                            result++;
                        }else{
                            break;
                        }
                        s = l;
                    }

                    /*s = i;
                    q = j; l = i + 1; r = j + 1;
                    while (l < m || r < n) {
                        if (mat[l][q] == 1 && mat[s][r] == 1 && mat[l][s] == 1) {
                            result++;
                        } else {
                            break;
                        }
                        s = l;
                    }*/
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumOfSubMatricesOfOne n = new NumOfSubMatricesOfOne();
        System.out.println(n.numSubmat(new int[][]{{1,0,1},{1,1,0},{1,1,0}}));
    }
}
