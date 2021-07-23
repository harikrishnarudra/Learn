package com.practice.leetcode.top100;

/**
 * 344. Reverse String
 *
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * Example 1:
 *
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 *
 *
 * Follow up: Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseString {

    public void reverseString(char[] s) {
        if(s==null || s.length<1){
            return;
        }
        int left = 0;
        int right = s.length-1;
        while (left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }

    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        //char[] s = {'a','b','c','d','e'};
        char[] s =new char[]{};
        reverseString.reverseString(s);
        for (char c:
             s) {
            System.out.println(c);
        }
    }
}
