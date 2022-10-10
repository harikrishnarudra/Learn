package com.practice.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * By simply changing the lookup condition, we can come up with previous greater element
 */
public class PreviousSmallerElements {

    private int[] prevSmallerElements(int[] arr){
        int[] result = new int[arr.length];
//        Stack<Integer> s = new Stack<>();
        Deque<Integer> s = new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            if(s.isEmpty()){
                result[i] = -1;
            }else{
                while(!s.isEmpty() && s.peek() >= arr[i]){
                    s.pop();
                }
                result[i] = s.isEmpty() ? -1 : s.peek();
            }
            s.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        PreviousSmallerElements previousSmallerElements = new PreviousSmallerElements();
//        int[] res = previousSmallerElements.prevSmallerElements(new int[]{4, 2, 1, 5, 6, 3, 2, 4, 2});
        int[] res = previousSmallerElements.prevSmallerElements(new int[]{4, 10, 5, 8, 20, 15, 3, 12});
        Arrays.stream(res).forEach(System.out::println);
    }
}
