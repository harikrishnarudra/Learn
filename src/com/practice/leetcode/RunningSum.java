package com.practice.leetcode;

import java.util.*;

public class RunningSum {

    public int[] runningSum(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        int sumVal = Arrays.stream(nums)
              .reduce((x,y) -> {
                ret.add(x);
                return x+y;}).orElseGet(()->0);
        ret.add(sumVal);
        return ret.stream().mapToInt(z -> z.intValue()).toArray();
    }

    public static void main(String[] args){

//        int[] nums = {1, 2, 3, 4};
//        int[] nums = {1, 1, 1, 1};
        int[] nums = {3, 1, 2, 10, 1};
        //int[] nums = {};
        RunningSum runningSumObj = new RunningSum();
        Arrays.stream(runningSumObj.runningSum(nums)).forEach(System.out::println);


    }
}
