package com.practice.leetcode.stringProbs;

/**
 * 1528. Shuffle String
 * You are given a string s and an integer array indices of the same length. The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
 *
 * Return the shuffled string.
 *
 * Example 1:
 * Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * Output: "leetcode"
 * Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
 *
 * Example 2:
 * Input: s = "abc", indices = [0,1,2]
 * Output: "abc"
 * Explanation: After shuffling, each character remains in its position.
 */
public class SecondSessionShuffleString {

    public String restoreStringWithExtraSpace(String s, int[] indices) {
        char[] ans = new char[indices.length];
        for(int i=0;i<indices.length;i++){
            ans[indices[i]] = s.charAt(i);
        }
        return new String(ans);
    }

    public String restoreStringShrink(String s, int[] indices) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < indices.length; i++) {
            while (indices[i] != i) {
                int tempInd = indices[indices[i]];
                char tempChar = chars[indices[i]];
                indices[indices[i]] = indices[i];
                chars[indices[i]] = chars[i];
                indices[i] = tempInd;
                chars[i] = tempChar;
            }
        }
        return new String(chars);
    }
    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        for(int i=0;i<indices.length;i++){
            while(indices[i]!=i){
                int currInd = indices[i];
                char currChar = chars[i];
                int tempInd = indices[currInd];
                char tempChar = chars[currInd];
                indices[currInd] = currInd;
                chars[currInd] = currChar;
                indices[i] = tempInd;
                chars[i] = tempChar;
            }
        }
        return new String(chars);
    }
    public static void main(String[] args) {
        SecondSessionShuffleString ss = new SecondSessionShuffleString();
        System.out.println(ss.restoreStringWithExtraSpace("teacher",new int[]{6,3,2,4,5,0,1}));
        System.out.println(ss.restoreStringWithExtraSpace("codeleet", new int[]{4,5,6,7,0,1,2,3}));
        System.out.println(ss.restoreStringWithExtraSpace("abc", new int[]{0,1,2}));
    }
}
