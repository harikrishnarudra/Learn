package com.practice.leetcode.stringProbs;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/description/
 *
 * 1071. Greatest Common Divisor of Strings
 *
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 *
 * Example 1:
 *
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 *
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 *
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 */
public class GCDOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) return "";
        int len = gcd(str1.length(), str2.length());
        return str2.substring(0, len);
    }
    private static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }

    //MY Idiotic code
    public String gcdOfStrings2(String str1, String str2) {
        Set<Character> visitedChars = new HashSet<>();
        String subStr = str1.length() > str2.length() ? str2 : str1;
        int len = subStr.length();
        String maxSubString = "";
        if (len > 0 && replaceableString(subStr, str1) && replaceableString(subStr, str2)) {
            return subStr;
        }
        for(int j=0;j<len;j++){
            if (!visitedChars.contains(str1.charAt(j)) && str1.charAt(j) == str2.charAt(j)) {
                visitedChars.add(str1.charAt(j));
            } else {
                String subString = str1.substring(0, j);
                if (subString.length() > 0 && replaceableString(subString, str1) && replaceableString(subString, str2)) {
                    if (subString.length() > maxSubString.length()) {
                        maxSubString = subString;
                    }
                }
            }
        }
        return maxSubString;
    }

    private boolean replaceableString(String subStr, String givenString){
        int len = givenString.length();
        int subLen = subStr.length();
        if(len%subLen == 0){
            int n = len/subLen;
            StringBuilder stringBuilder = new StringBuilder();
            int k=0;
            while(k < n){
                stringBuilder.append(subStr);
                k++;
            }
            return stringBuilder.toString().equalsIgnoreCase(givenString);
        }
        return false;
    }

    public static void main(String[] args) {
        GCDOfStrings g = new GCDOfStrings();
        System.out.println(g.gcdOfStrings("ABABAB", "AB"));
        System.out.println(g.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(g.gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(g.gcdOfStrings("LEET", "CODE"));
        System.out.println(g.gcdOfStrings("ABAABA", "ABA"));
        System.out.println(g.gcdOfStrings("ABABABAB", "ABAB"));
    }
}
