package com.test.learn.leetcode;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunningSum {

    public int[] runningSum(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        int sumVal = Arrays.stream(nums)
              .reduce((x,y) -> {
                ret.add(x);
                return x+y;}).orElseGet(()->0);
        ret.add(sumVal);
        return ret.stream().mapToInt(z -> z.intValue()).toArray();

        /*Stream.of(nums)
              .mapToInt(value -> )
              .forEach(System.out::println);*/

        //return nums;
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
