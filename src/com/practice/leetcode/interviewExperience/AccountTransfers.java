package com.practice.leetcode.interviewExperience;

public class AccountTransfers {

    public int[] solution(String R, int[] V) {
        // write your code in Java SE 8
        char[] accounts = R.toCharArray();
        int n = V.length;
        if (n == 1) {
            if (accounts[0] == 'B') {
                return new int[]{V[0], 0};
            } else {
                return new int[]{0, V[0]};
            }
        }
        int minA = 0, minB = 0, A = 0, B = 0;
        for (int i = 0; i < n; i++) {
            int val = V[i];
            char acc = accounts[i];
            if (acc == 'A') {
                A += val;
                B -= val;
                if (B < 0) {
                    minB += Math.abs(B);
                    B = 0;
                }

            } else if (acc == 'B') {
                B += val;
                A -= val;
                if (A < 0) {
                    minA += Math.abs(A);
                    A = 0;
                }
            }
        }
        return new int[]{minA, minB};
    }
}
