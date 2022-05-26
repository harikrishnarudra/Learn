package com.practice.leetcode;

import java.util.Stack;

public class BackSpaceCompare {
    public boolean backspaceCompare(String s, String t) {
        if (s.equalsIgnoreCase(t)) {
            return true;
        }
        Stack<Character> sStack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if(!sStack.isEmpty()){
                    sStack.pop();
                }
            }else{
                sStack.push(s.charAt(i));
            }
        }
        StringBuffer sStrB = new StringBuffer();
        while(!sStack.isEmpty()){
            sStrB.append(sStack.pop());
        }
        String sFinal = sStrB.toString();

        Stack<Character> tStack = new Stack();
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (!tStack.isEmpty()) {
                    tStack.pop();
                }
            } else {
                tStack.push(t.charAt(i));
            }
        }
        StringBuffer tStrB = new StringBuffer();
        while (!tStack.isEmpty()) {
            tStrB.append(tStack.pop());
        }
        String tFinal = tStrB.toString();
        return sFinal.equalsIgnoreCase(tFinal);
    }

    public static void main(String[] args) {
        BackSpaceCompare b = new BackSpaceCompare();
        System.out.println(b.backspaceCompare("a#b", "c"));
        System.out.println(b.backspaceCompare("ab#c", "ad#c"));
        System.out.println(b.backspaceCompare("ab#cd#e##", "a"));
    }
}
