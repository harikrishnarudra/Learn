package com.practice.leetcode.stringProbs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1769. Minimum Number of Operations to Move All Balls to Each Box
 * You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
 *
 * In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.
 *
 * Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.
 *
 * Each answer[i] is calculated considering the initial state of the boxes.
 *
 * Example 1:
 *
 * Input: boxes = "110"
 * Output: [1,1,3]
 * Explanation: The answer for each box is as follows:
 * 1) First box: you will have to move one ball from the second box to the first box in one operation.
 * 2) Second box: you will have to move one ball from the first box to the second box in one operation.
 * 3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.
 * Example 2:
 *
 * Input: boxes = "001011"
 * Output: [11,8,5,4,3,4]
 */
public class MinOperations {
    public int[] minOperations2(String boxes) {
        char[] chars = boxes.toCharArray();
        int len = chars.length;
        int[] values = new int[len];
        List<Integer> ll = new ArrayList<>();
        for(int i=0; i<len; i++){
            if(chars[i]=='1'){
                ll.add(i);
            }
        }
        for(int i=0; i< len; i++){
            for(int k=0; k<ll.size();k++){
                values[i] += Math.abs(ll.get(k) - i);
            }
        }
        return values;
    }

    public int[] minOperations3(String boxes) {
        char[] chars = boxes.toCharArray();
        int len = chars.length;
        int[] values = new int[len];
        for (int i = 0; i < len; i++) {
            for(int j=0; j< len; j++){
                if (chars[j] == '1') {
                    values[i] += Math.abs(j - i);
                }
            }
        }
        return values;
    }

    public int[] minOperations4(String boxes) {
        char[] chars = boxes.toCharArray();
        int len = chars.length;
        int[] values = new int[len];
        int m = 0;
        List<Integer> ll = new ArrayList<>();
        for(int i=0; i< len; i++){
            if (chars[i] == '1') {
                ll.add(i);
                values[i] += Math.abs(i - m);
            }
        }
        /*for (int i = 1; i < len; i++) {
            values[i] += Math.abs(j - i);
        }*/
        return values;
    }

    public int[] minOperations(String boxes) {
        char[] chars = boxes.toCharArray();
        int len = chars.length;
        int[] result = new int[len];
        for(int k=0; k<len; k++){
            int kthCount = 0, startInd = 0, endInd = len-1;
            while(startInd != k){
                if(chars[startInd] == '1'){
                    kthCount += Math.abs(k-startInd);
                }
                startInd++;
            }
            while (endInd != k){
                if(chars[endInd] == '1'){
                    kthCount += Math.abs(k - endInd);
                }
                endInd--;
            }
            result[k] = kthCount;
        }
        return result;
    }

    public static void main(String[] args) {
        MinOperations m = new MinOperations();
        int[] res = m.minOperations("001011");
        Arrays.stream(res).forEach(System.out::println);
        res = m.minOperations("110");
        Arrays.stream(res).forEach(System.out::println);
    }
}
