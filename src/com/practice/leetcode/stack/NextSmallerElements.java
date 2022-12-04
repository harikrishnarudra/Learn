package com.practice.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextSmallerElements {

    public int[] nextSmallerElements(int[] arr){
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[arr.length];
        for(int i = arr.length-1; i>=0; i--){
            if(deque.isEmpty()){
                result[i] = -1;
            }else{
                while(!deque.isEmpty() && deque.peek() > arr[i]){
                    deque.pop();
                }
                result[i] = deque.isEmpty() ? -1: deque.peek();
            }
            deque.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        NextSmallerElements nextSmallerElements = new NextSmallerElements();
        int[] res = nextSmallerElements.nextSmallerElements(new int[]{4, 10, 5, 8, 20, 15, 3, 12});
        Arrays.stream(res).forEach(System.out::println);
    }
}
