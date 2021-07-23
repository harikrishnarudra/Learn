package com.practice.leetcode.stringProbs;

public class BalancedStringSplit {

    public static int balancedStringSplit2(String s) {
        int result = 0;
        int lCount = 0, rCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                lCount++;
            }
            if (s.charAt(i) == 'R') {
                rCount++;
            }
            if (lCount == rCount) {
                result++;
                lCount = 0;
                rCount = 0;
            }
        }
        return result;
    }

    public static int balancedStringSplit(String s) {
        int result = 0;
        int lCount = 0, rCount = 0;
        for (char c:s.toCharArray()) {
            if (c == 'L') {
                lCount++;
            }
            if (c == 'R') {
                rCount++;
            }
            if (lCount == rCount) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
        System.out.println(balancedStringSplit("LLLLRRRR"));
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
    }
}
