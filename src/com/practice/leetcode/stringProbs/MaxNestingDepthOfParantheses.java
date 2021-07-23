package com.practice.leetcode.stringProbs;

import java.util.Stack;

public class MaxNestingDepthOfParantheses {
    public static int maxDepth(String s) {
        int count = 0;
        int max = 0;
        for (char c:s.toCharArray()) {
            if(c=='('){
                count++;
                if (count > max) {
                    max = count;
                }
            }
            if (c == ')') {
                count --;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
        System.out.println(maxDepth("1+(2*3)/(2-1)"));
        System.out.println(maxDepth("1"));
    }
}
