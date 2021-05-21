package com.test.leetcode.dp.linearDp;

/**
 * 357. Count Numbers with Unique Digits
 * Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 91
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, excluding 11,22,33,44,55,66,77,88,99
 * Example 2:
 *
 * Input: n = 0
 * Output: 1
 *
 * Constraints:
 *
 * 0 <= n <= 8
 */
public class CountUniqueDigitNumbers {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(countUniques(n));
    }
    private static int countUniques(int n){
        int countOfUniqueDigitNumbers = 1;
        if(n==0){
            return countOfUniqueDigitNumbers;
        }
        if(n>0){
            int max = (int) Math.pow(10,n);
            for(int i=1;i<max;i++){
                if(!numHasUniqueDigits(i)){
                    countOfUniqueDigitNumbers++;
                }
            }
        }
        return countOfUniqueDigitNumbers;
    }
    private static boolean numHasUniqueDigits(int val){
        String s = String.valueOf(val);
        char[] chars = s.toCharArray();
        for(int k=0;k<s.length();k++){
            String substring = s.substring(k + 1);
            if(substring.contains(String.valueOf(chars[k]))){
                return true;
            }
        }
        return false;
    }
}
