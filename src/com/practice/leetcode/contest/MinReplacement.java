package com.practice.leetcode.contest;

import java.util.Stack;

public class MinReplacement {
    public long minimumReplacement(int[] nums) {
        int len = nums.length;
        int lp = len-1;
        int minEle = nums[lp];
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(minEle);
        for(int k=len-2;k>=0;k--){
            if(nums[k] > minEle){
                int kEle = nums[k];
                int firstHalf = kEle/2;
                int secHalf = kEle - firstHalf;
                while (secHalf > minEle){
                    secHalf = secHalf-1;
                    firstHalf = firstHalf+1;
                }
                stack.push(secHalf);
                result++;
                result = breakElements(secHalf, firstHalf, stack, result);
                minEle = stack.peek();
            }else{
                stack.push(nums[k]);
                minEle = nums[k];
            }
        }
        return result;
    }

    private int breakElements(int minEle, int eleToBreak, Stack<Integer> stack, int result){
        while(eleToBreak > minEle) {
            int firstHalf = eleToBreak / 2;
            int secHalf = eleToBreak - firstHalf;
            while (secHalf > minEle) {
                secHalf = secHalf - 1;
                firstHalf = firstHalf + 1;
            }
            stack.push(secHalf);
            result++;
            minEle = secHalf;
            eleToBreak = firstHalf;
        }
        stack.push(eleToBreak);
        return result;
    }

    public static void main(String[] args) {
        MinReplacement m = new MinReplacement();
        System.out.println(m.minimumReplacement(new int[]{3,9,3}));
        System.out.println(m.minimumReplacement(new int[]{1,2,3,4,5}));
        System.out.println(m.minimumReplacement(new int[]{12, 9, 7, 6, 17, 19, 21}));
    }
}
