package com.practice.leetcode.contest;

public class LongestContinuousSubstring {
    public int longestContinuousSubstring(String s) {
        if(s==""){
            return 0;
        }
        int start = s.charAt(0);
        int prev = s.charAt(0);
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            if (++prev == s.charAt(i)) {
                prev = s.charAt(i);
                if ((prev - start+1) > max) {
                    max = prev - start +1;
                }
            } else {
                if (prev - start > max) {
                    max = prev - start;
                }
                start = s.charAt(i);
                prev = s.charAt(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestContinuousSubstring l = new LongestContinuousSubstring();
        System.out.println(l.longestContinuousSubstring("abcdefghijklmnopqrstuvwxyz"));
        System.out.println(l.longestContinuousSubstring("abacaba"));
        System.out.println(l.longestContinuousSubstring("a"));
        System.out.println(l.longestContinuousSubstring(""));
    }
}
