package com.practice.leetcode.stringProbs;

/**
 * 1221. Split a String in Balanced Strings
 * Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
 * Given a balanced string s, split it in the maximum amount of balanced strings.
 * Return the maximum amount of split balanced strings.
 *
 * Example 1:
 *
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 *
 * Example 2:
 *
 * Input: s = "RLLLLRRRLR"
 * Output: 3
 * Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
 *
 * Example 3:
 *
 * Input: s = "LLLLRRRR"
 * Output: 1
 * Explanation: s can be split into "LLLLRRRR".
 */
public class SecSesBalancedStringSplit {
    public int balancedStringSplit(String s) {
        int count = 0;
        int res = 0;
        if(s.charAt(0)=='L'){
            count = 1;
        }
        else{
            count = -1;
        }
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) == 'L') {
                count++;
            }
            if (s.charAt(i) == 'R') {
                count--;
            }
            if (count == 0 ) {
                res++;
            }
        }
        return res;
    }
    public int balancedStringSplit2(String s) {
        int lcount = 0;
        int rcount = 0;
        int res = 0;
        for(char c:s.toCharArray()){
            if(c=='L'){
                lcount++;
            }
            if (c == 'R') {
                rcount++;
            }
            if(lcount == rcount){
                res++;
                lcount = rcount = 0;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        SecSesBalancedStringSplit s = new SecSesBalancedStringSplit();
        System.out.println(s.balancedStringSplit("LRRRRLLLRL"));
        System.out.println(s.balancedStringSplit("RLRRLLRLRL"));
        System.out.println(s.balancedStringSplit("RLLLLRRRLR"));
        System.out.println(s.balancedStringSplit("LLLLRRRR"));
    }
}
