package com.practice.leetcode.contest;

import java.util.HashSet;
import java.util.Set;

public class NumberOfRepeatedDigits {
    public int numDupDigitsAtMostN(int n) {
        Set<Integer> set = new HashSet();
        int resCount = 0;
        for (int i = 1; i <= n; i++) {
            if (isSpecial(i)) {
                set.add(i);
                resCount++;
            }
        }
        return resCount;
    }

    private boolean isSpecial(int n) {
        int xored = 0;
        while (n > 0) {
            int mod = n%10;
            xored ^= mod;
            n = n / 10;
            if (mod!=0  && xored == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isSpecial2(int n){
        char[] chars = String.valueOf(n).toCharArray();
        Set<Character> charSet = new HashSet<>();
        for(char i:chars){
            charSet.add(i);
        }
        return charSet.size() == chars.length;
    }

    public static void main(String[] args) {
        NumberOfRepeatedDigits numberOfRepeatedDigits = new NumberOfRepeatedDigits();
        System.out.println(numberOfRepeatedDigits.numDupDigitsAtMostN(20));
    }
}
