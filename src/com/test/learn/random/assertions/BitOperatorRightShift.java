package com.test.learn.random.assertions;

public class BitOperatorRightShift {
    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            int k = i >> 1;
            System.out.println(i + " >> 1=" + k);
            int m = k+ (i&1);
            System.out.println(m);
        }
    }
}
