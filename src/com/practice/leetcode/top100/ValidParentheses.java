package com.practice.leetcode.top100;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 * Example 4:
 *
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 *
 * Input: s = "{[]}"
 * Output: true
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        boolean isValid = false;
        if(s.isEmpty()){
            isValid=true;
        }
        if(!s.isEmpty()){
            Stack<Character> stack = new Stack<>();
            char[] arr = s.toCharArray();
            int index=0;
            Map<Character,Character> map = new HashMap<>();
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');
            final Collection<Character> values = map.values();
            while(index < arr.length){
                char ele = arr[index++];
                if(values.contains(ele)){
                    if(stack.isEmpty()){
                        return false;
                    }
                    else if(map.get(stack.pop())!=ele){
                        return false;
                    }
                    isValid=true;
                }
                else{
                    stack.push(ele);
                }
            }
            if(stack.isEmpty()) {
                isValid=true;
            }
            else{
                isValid=false;
            }
        }
        return isValid;
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int index = 0;
        while (index < arr.length) {
            char ele = arr[index++];
            if(ele=='(') {
                stack.push(')');
            }
            else if (ele == '{') {
                stack.push('}');
            }
            else if (ele == '[') {
                stack.push(']');
            }
            else if(stack.isEmpty() || stack.pop()!=ele) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid2(""));
        System.out.println(validParentheses.isValid2("()"));
        System.out.println(validParentheses.isValid2("()[]{}"));
        System.out.println(validParentheses.isValid2("([)]"));
        System.out.println(validParentheses.isValid2("(]"));
        System.out.println(validParentheses.isValid2("{[]}"));
        System.out.println(validParentheses.isValid2("("));
        System.out.println(validParentheses.isValid2("([]){"));
    }
}
