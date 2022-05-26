package com.practice.leetcode.ggle;

import org.springframework.data.domain.Sort;

import java.util.Arrays;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int[] ans = new int[A.length];
        int t = 0;

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 0)
                ans[t++] = A[i];

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 1)
                ans[t++] = A[i];

        return ans;
    }

    public int[] sortArrayByParity2(int[] A) {
        int i=0, j = A.length-1, temp=0;
        while (i<j){
            if(A[i]%2 > A[j]%2){
                temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
            if(A[i]%2==0) i++;
            if (A[j] % 2 == 1) j--;
        }
        return A;
    }


    public static void main(String[] args) {
        SortArrayByParity s = new SortArrayByParity();
        int[] res = s.sortArrayByParity2(new int[]{3,1,2,4});
        Arrays.stream(res).forEach(System.out::println);
    }
}
