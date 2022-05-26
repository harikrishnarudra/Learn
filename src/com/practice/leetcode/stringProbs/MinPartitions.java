package com.practice.leetcode.stringProbs;

/**
 *
 */
public class MinPartitions {
    public int minPartitions(String n) {
        char[] nums = n.toCharArray();
        int maxNum = 0;
        for(int i=0;i<nums.length;i++){
            int i1 = Integer.parseInt(String.valueOf(nums[i]));
            if(i1 > maxNum){
                maxNum = i1;
            }
        }
        return maxNum;
    }
    //This is ideal solution
    public int minPartitions2(String n) {
        int i = 9;
        for(; i>=0; i--){
            if(n.contains(String.valueOf(i))){
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        MinPartitions m = new MinPartitions();
        System.out.println(m.minPartitions2("32"));
        System.out.println(m.minPartitions2("82734"));
        System.out.println(m.minPartitions2("27346209830709182346"));
    }
}
