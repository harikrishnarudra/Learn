package com.practice.leetcode.interviewExperience;

import java.util.Stack;

/**
 * 1047. Remove All Adjacent Duplicates In String
 * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 *
 * We repeatedly make duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 *
 * Example 1:
 *
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * Example 2:
 *
 * Input: s = "azxxzy"
 * Output: "ay"
 */

public class RemoveAdjDuplicatesFromAString {

    public String removeDuplicates2(String s) {
        String res = "";
        if (s == null) return res;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == curr) {
                stack.pop();
            }
            else {
                stack.push(curr);
            }
        }
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        String finalRes = "";
        for(int i=res.length()-1;i>=0;i--){
            finalRes += res.charAt(i);
        }
        return finalRes;
    }

    public String removeDuplicates3(String s) {
        StringBuffer sb = new StringBuffer();
        if (s == null) return sb.toString();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (sb.length()>=1 && sb.charAt(sb.length()-1)==curr) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(curr);
            }
        }
        return sb.toString();
    }

    //2 ms solution

    public String removeDuplicates4(String s) {
        if(s==null) return s;
        int end=-1;

        char[] chars = s.toCharArray();
        for (char c:chars) {
            if(end > -1 && chars[end]==c){
                end--;
            }
            else {
                chars[++end]=c;
            }
        }
        return String.valueOf(chars,0,end+1);
    }

    public String removeDuplicates5(String s) {
        if (s == null) return s;
        int end = -1;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (end > -1 && s.charAt(end) == curr) {
                end--;
            } else {
                s=s.replace(s.charAt(++end), curr);
            }
        }
        return s.substring(0, end+1);
    }


    public static void main(String[] args) {
        RemoveAdjDuplicatesFromAString removeAdjDuplicatesFromAString = new RemoveAdjDuplicatesFromAString();
        System.out.println(removeAdjDuplicatesFromAString.removeDuplicates5("xyzzzyzx"));
    }
}
