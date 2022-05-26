package com.practice.interviewBit;

public class SpiralOrderMatrix {
    public static void main(String[] args) {
//        int[][] a = new int[][] {{1,2,3,4,5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] a = new int[][]{{1, 2, 3, 4}, {6, 7, 8, 9}, {11, 12, 13, 14}};
        int n=a.length, m= a[0].length, k=0, p=0;
        int i=0, j=0;
        int q= m/2, r = n/2;
        while(m > q || n > r ){
            while(j < m){
                System.out.println(a[i][j++]);
            }
            i++;
            j--;
            while (i < n) {
                System.out.println(a[i++][j]);
            }
            i--;
            j--;
            while (j >= p){
                System.out.println(a[i][j--]);
            }
            p++;
            j++;
            k++;
            while (i > k) {
                System.out.println(a[--i][j]);
            }
            j++;
            m--;
            n--;
        }
    }
}
