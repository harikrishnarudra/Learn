package com.practice.learn.random.assertions;

import java.util.Arrays;

public class CreateAManipulatedArrayFromArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,0,1};
        int[] ints = Arrays.stream(arr1).map(i -> 1-i).toArray();
        Arrays.stream(ints).forEach(System.out::println);
    }
}
