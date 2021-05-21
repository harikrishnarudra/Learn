package com.test.learn.random.assertions;

/**
 * Bit operator AND (&) with any number gives boolean result either 1 or 0.
 */
public class BitOperatorAnd {

    public static void main(String[] args) {
        for(int i=0;i<15;i++){
            int k = i & 1;
            System.out.println(i+" & 1="+k);
        }
    }
}
