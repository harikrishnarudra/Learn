package com.practice.leetcode.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPalindromes {
    public int maxPalindromesOverlapping(String s, int k) {
        int result = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            int j = s.indexOf(c, i+1);
            while(j< len && j > i){
                if ((j-i+1) >= k && isPalindrome(s, i, j+1)) {
                    result++;
                }
                j = s.indexOf(c, j+1);
            }
        }
       return result;
    }

    public int maxPalindromes(String s, int k) {
        int result = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        int inc = 1;
        if(k==1){inc=0;}
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            int j = s.indexOf(c, i + inc);
            while (j < len) {
                if ((j - i + 1) >= k && isPalindrome(s, i, j + 1)) {
                    result++;
                    i=j+1;
                    if(i < len) {
                        c = chars[i];
                        j = s.indexOf(c, i + inc);
                    }else{
                        break;
                    }
                }else {
                    j = s.indexOf(c, j + inc);
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s, int i, int j){
        String subStr = s.substring(i, j);
        String rev = new StringBuilder(subStr).reverse().toString();
        return subStr.equalsIgnoreCase(rev);
    }

    public static void main(String[] args) {
        MaxPalindromes m = new MaxPalindromes();
        System.out.println(m.maxPalindromes("abaccdbbd", 3));
        System.out.println(m.maxPalindromes("adbcda", 2));
        System.out.println(m.maxPalindromes("fttfjofpnpfydwdwdnns", 2));
        System.out.println(m.maxPalindromes("kwnwkekokedadq" , 5));
        System.out.println(m.maxPalindromes("iqqibcecvrbxxj", 1));
    }

}
