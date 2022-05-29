package com.practice.leetcode;

import java.text.DecimalFormat;

public class DiscountPrices {
    String decDot = "0123456789.";
    private static final DecimalFormat dfZero = new DecimalFormat("0.00");
    public String discountPrices(String sentence, int discount) {
        StringBuffer strB = new StringBuffer();
        int i = -1, j = -1;
        char[] arr = sentence.toCharArray();
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] == '$') {
                i = k;
                j = k;
                while (j< arr.length &&  arr[j] != ' ') {
                    j++;
                }
                if (isValid(sentence, i, j)) {
                    double val = Double.parseDouble(sentence.substring(i + 1, j));
                    double res = (val * discount) / 100.0;
                    res = val-res;
                    String format = dfZero.format(res);
                    strB.append(arr[i]);
                    strB.append(format);
                }else{
                    String s = sentence.substring(i, j);
                    strB.append(s);
                }
                k = j - 1;
            } else {
                strB.append(arr[k]);
            }
        }
        return strB.toString();
    }

    private boolean isValid(String sentence, int i, int j) {
        String s = sentence.substring(i+1, j);
        char[] cc = s.toCharArray();
        boolean isValid = false;
        for (int k = 0; k < cc.length; k++) {
            if (decDot.contains(String.valueOf(cc[k]))) {
                isValid= true;
            }else{
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    public static void main(String[] args) {
        DiscountPrices d = new DiscountPrices();
        System.out.println(d.discountPrices("there are $1 $2 and 5$ candies in the shop", 50));

        System.out.println(d.discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 50));
    }
}
