package com.practice.leetcode.contest;

public class MostFrequentEven {

    public int mostFrequentEven(int[] nums) {
        int[] arr = new int[10_000];
        for(int num:nums){
            ++arr[num];
        }
        int max = 0;
        int result = -1;
        for(int i=0; i< arr.length; i+=2){
            if(max < arr[i]){
                max = arr[i];
                result = i;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        MostFrequentEven m = new MostFrequentEven();
        System.out.println(m.mostFrequentEven(new int[]{0, 1, 2, 2, 4, 4, 1}));
    }
}
