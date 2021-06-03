package com.practice.leetcode.dp.linearDp;

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
 *
 *
 * Solution:
 * Following the hint. Let f(n) = count of number with unique digits of length n.
 *
 * f(1) = 10. (0, 1, 2, 3, ...., 9)
 *
 * f(2) = 9 * 9. Because for each number i from 1, ..., 9, we can pick j to form a 2-digit number ij and there are 9 numbers that are different from i for j to choose from.
 *
 * f(3) = f(2) * 8 = 9 * 9 * 8. Because for each number with unique digits of length 2, say ij, we can pick k to form a 3 digit number ijk and there are 8 numbers that are different from i and j for k to choose from.
 *
 * Similarly f(4) = f(3) * 7 = 9 * 9 * 8 * 7....
 *
 * ...
 *
 * f(10) = 9 * 9 * 8 * 7 * 6 * ... * 1
 *
 * f(11) = 0 = f(12) = f(13)....
 *
 * any number with length > 10 couldn't be unique digits number.
 *
 * The problem is asking for numbers from 0 to 10^n. Hence return f(1) + f(2) + .. + f(n)
 */
public class CountUniqueDigitNumbers {
    public static void main(String[] args) {
        int n = 5;
        for(int i=0;i<=n;i++) {
            System.out.println(dp3CountUniques(i));
        }
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

    private static int dpCountUniques(int n){
        int res = 0;
        int[] ans = new int[2];
        ans[0] = 1;
        ans[1] = 9;

        if(n>=2){
            ans = new int[n + 1];
            ans[0] = 1;
            ans[1] = 9;
            int[] calc = new int[n];
            calc[0] = 9;
            calc[1] = 9;

            for(int i=2; i< calc.length; i++){
                calc[i] = calc[i-1]-1;
            }
            for(int j=2;j< ans.length;j++){
                int k = j-1;
                int temp = 1;
                while (k>=0){
                    temp *= calc[k--];
                }
                ans[j] = temp;
            }
        }
        for(int i=0; i<= n; i++){
            res += ans[i];
        }
        return res;
    }

    private static int dp2CountUniques(int n) {
        if(n==0) return 1;
        int res = 10;
        int mul = 9;
        int fact = 9;
        int i=1;
        while (i++<n){
            mul *= fact--;
            res += mul;
        }
        return res;
    }

    /**
     * It is taking more memory compared to dp2CountUniques
     * @param n
     * @return
     */
    private static int dp3CountUniques(int n) {
        if (n == 0) return 1;
        int res = 10,  mul = 9, fact = 9;
        while (n--> 1) {
            mul *= fact--;
            res += mul;
        }
        return res;
    }
}
