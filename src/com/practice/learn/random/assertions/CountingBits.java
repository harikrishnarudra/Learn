package com.practice.learn.random.assertions;

public class CountingBits {
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        int[] ints = countingBits.countBits(15);
        for (int k:ints
             ) {
            System.out.println(k);
        }
    }
}
