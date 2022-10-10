package com.practice.leetcode.stringProbs;

import org.junit.Assert;

import java.util.Stack;

/**
 * 394. Decode String
 */
public class DecodeString {
    /*public String decodeString(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                String str = "";
                char ele;
                while (!stack.isEmpty() && ((ele = stack.pop()) != '[')) {
                    str = ele+""+str;
                }
                char c = stack.pop();
                while(Character.isDigit(c))
                int mul = Integer.parseInt(String.valueOf(stack.pop()));
                for(int j=0;j<mul;j++){
                    str += str;
                }
                stack.push(str);
            }else{
                stack.push(String.valueOf(s.charAt(i)));
            }

        }
        return stack.pop();
    }*/




    public String decodeString2(String s) {
        Stack<String> stack = new Stack();
        boolean isPrevChar = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                if (!stack.isEmpty()) {
                    String ele = stack.pop();
                    int mul = Integer.parseInt(stack.pop());
                    String res = "";
                    if (!stack.isEmpty()) {
                        res = stack.pop();
                    }
                    for (int j = 0; j < mul; j++) {
                        res += ele;
                    }
                    isPrevChar = true;
                    stack.add(res);
                }
            } else if (s.charAt(i) != '[') {
                if (isPrevChar && !stack.isEmpty()) {
                    if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                        stack.add(String.valueOf(s.charAt(i)));
                        isPrevChar = false;
                    }else {
                        String ele = stack.pop();
                        ele += String.valueOf(s.charAt(i));
                        isPrevChar = true;
                        stack.add(ele);
                    }
                } else {
                    if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                        isPrevChar = true;
                    }
                    stack.add(String.valueOf(s.charAt(i)));
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        DecodeString d = new DecodeString();
        /*System.out.println(d.decodeString("3[abc]"));
        System.out.println(d.decodeString("3[a]2[bc]"));
        System.out.println(d.decodeString("3[a2[c]]"));
        System.out.println(d.decodeString("2[abc]3[cd]ef"));
        System.out.println(d.decodeString("100[leetcode]"));*/
        /*Assert.assertEquals("abcabcabc", d.decodeString("3[abc]"));
        Assert.assertEquals("aaabcbc", d.decodeString("3[a]2[bc]"));
        Assert.assertEquals("accaccacc", d.decodeString("3[a2[c]]"));
        Assert.assertEquals("abcabccdcdcdef", d.decodeString("2[abc]3[cd]ef"));*/
    }
}
