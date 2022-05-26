package com.practice.leetcode;

import java.math.BigInteger;

public class RemoveDigit {
    public String removeDigit(String number, char digit) {
        BigInteger max = BigInteger.ONE;
        int index = number.indexOf(digit, 0);
        while (index != -1) {
            String s = "";
            int startInd = 0;
            if (index == 0) {
                s = number.substring(1);
            } else {
                s = number.substring(startInd, index) + "" + number.substring(index + 1);
            }
            BigInteger bigInteger = new BigInteger(s);
            max = bigInteger.max(max);
            index = number.indexOf(digit, index + 1);
        }
        return String.valueOf(max);
    }

    public static void main(String[] args) {
        RemoveDigit r = new RemoveDigit();
        System.out.println(r.removeDigit("123", '3'));
        System.out.println(r.removeDigit("551", '5'));
        System.out.println(r.removeDigit("2998589353917872714814599237991174513476623756395992135212546127959342974628712329595771672911914471", '3'));
    }
}
