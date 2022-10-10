package com.practice.leetcode.contest;

public class MinimalXOR {
    public int minimizeXor(int num1, int num2) {
        int minimal = Integer.MAX_VALUE;
        int actVal = -1;
        int nBits = Integer.bitCount(num2);
        for (int i = 1; i <= 1000000000; i++) {
            if (Integer.bitCount(i) == nBits) {
                int res = num1 ^ i;
                if (res < minimal) {
                    minimal = res;
                    actVal = i;
                }
            }
        }
        return actVal;
    }

    public static void main(String[] args) {
        MinimalXOR minimalXOR = new MinimalXOR();
        System.out.println(minimalXOR.minimizeXor(1, 12));
        System.out.println(minimalXOR.minimizeXor(3, 5));
        System.out.println(minimalXOR.minimizeXor(79, 74));
    }
}
