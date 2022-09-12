package com.practice.leetcode.arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] A){
        int n = A.length;
        for(int i=0;i<n;i++){
            while(A[i]>0 && A[i]<=n && A[A[i]-1]!=A[i]){
                int tempIndex = A[i] - 1;
                int temp = A[i];
                A[i] = A[A[i] - 1];
                A[tempIndex] = temp;
            }
        }

        for(int i=0;i<n;i++){
            if(A[i] != i+1){
                return i+1;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        FirstMissingPositive f = new FirstMissingPositive();
//        System.out.println(f.firstMissingPositive(new int[]{3,4,-1,-2,1,5,16,0,2,0}));
        System.out.println(f.firstMissingPositive(new int[]{3,4,-1,1}));
    }

}
