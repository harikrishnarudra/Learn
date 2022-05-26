package com.practice.interviewBit;

import java.util.Arrays;

public class SegregateZerosAndOnes {
    // With extra memory
    public int[] solve(int[] A) {
        int oneCount = 0;
        int len = A.length;
        for(int i:A){
            if(i==1){
                oneCount++;
            }
        }
        int[] res = new int[len];
        for(int i=len-1;i>=len-oneCount; i--){
            res[i]=1;
        }
        return res;
    }

    /**
     * Without extra memory
     * @param A
     * @return
     */
    public int[] solve2(int[] A){
        int zeroCount = 0;
        int len = A.length;
        for (int i : A) {
            if (i == 0) {
                zeroCount++;
            }
        }
        for (int i = 0; i <= zeroCount; i++) {
            A[i] = 0;
        }
        for (int i = zeroCount; i < len; i++) {
            A[i] = 1;
        }
        return A;
    }

    public static void main(String[] args) {
        SegregateZerosAndOnes s = new SegregateZerosAndOnes();
        int[] res = s.solve2(new int[]{1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1});
        Arrays.stream(res).forEach(System.out::println);
    }
}
