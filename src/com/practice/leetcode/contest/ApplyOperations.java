package com.practice.leetcode.contest;

import java.util.Arrays;

public class ApplyOperations {
    public int[] applyOperations(int[] nums) {
        int zeroCnt = 0, k = 0;
        int[] result = new int[nums.length];
        if(nums[0]==0){
            zeroCnt++;
        }
        for (int i=1; i < nums.length; i++) {
            if(nums[i-1]==0){
                zeroCnt++;
            }else if(nums[i] == nums[i - 1]) {
                result[k++] = nums[i - 1] * 2;
                i = i + 1;
                zeroCnt++;
            } else {
                result[k++] = nums[i - 1];
            }
        }
        for (int m = 0; m < zeroCnt; m++) {
            result[k + m] = 0;
        }
        return result;
    }

    public int[] applyOperations2(int[] nums) {
        int zeroCnt = 0, k=0, i = 0;
        int[] result = new int[nums.length];
        for(;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                result[k++] = nums[i]*2;
                i=i+1;
                zeroCnt++;
            }else{
                if(nums[i]!=0) {
                    result[k++] = nums[i];
                }else{
                    zeroCnt++;
                }
            }
        }
        if (i < nums.length) {
            if (nums[i] != 0) {
                result[k++] = nums[nums.length - 1];
            } else {
                zeroCnt++;
            }
        }
        for(int m=0;m<zeroCnt;m++){
            result[k+m] = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        ApplyOperations a = new ApplyOperations();
        int[] res = a.applyOperations(new int[]{1,2,2,1,1,0});
        Arrays.stream(res).forEach(System.out::println);
        /*System.out.println("-----------");
        res = a.applyOperations(new int[]{0, 1});
        Arrays.stream(res).forEach(System.out::println);
        System.out.println("-----------");
        res = a.applyOperations(new int[]{0});
        Arrays.stream(res).forEach(System.out::println);
        System.out.println("-----------");
        res = a.applyOperations(new int[]{1});
        Arrays.stream(res).forEach(System.out::println);
        System.out.println("-----------");
        res = a.applyOperations(new int[]{1, 1});
        Arrays.stream(res).forEach(System.out::println);*/
        System.out.println("-----------");
        res = a.applyOperations(new int[]{847, 847, 0, 0, 0, 399, 416, 416, 879, 879, 206, 206, 206, 272});
        Arrays.stream(res).forEach(System.out::println);
    }
}
