package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayShuffle {

    /*public int[] shuffle2(int[] nums, int n) {
        List<Integer> resList = new ArrayList<Integer>();
        IntStream.range(0, (nums.length)/2)
                .filter(index -> )
                .flatMap(index -> resList.add(nums[index]))
                .flatMap(index ->{
                    int secInd = ((nums.length)/2)*index;
                    return IntStream.of(nums[secInd]);
                })
        return null;
    }*/

    public int[] shuffle3(int[] nums, int n) {
        int [] resList = {};
        int leng = nums.length;
        if (leng % 2 != 0) {
            return null;
        }
        int nextInd = leng / 2;
        for (int i = 0; i < leng / 2; i=i+2) {
            resList[i] = nums[i];
            resList[i++] = nums[nextInd];
            nextInd += 1;
        }
        return resList;
    }

    public int[] shuffle(int[] nums, int n) {
        int leng = nums.length;
        if (leng%2!=0){
            return null;
        }
        List<Integer> resList = new ArrayList<Integer>();
        int nextInd = leng/2;
        for (int i=0;i<leng/2;i++){
            resList.add(nums[i]);
            resList.add(nums[nextInd]);
            nextInd += 1;
        }

        int[] objects = resList.stream().flatMapToInt(obj -> {
            return IntStream.of(obj);
        }).toArray();
        return objects;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 2;
        int[] retList = new ArrayShuffle().shuffle(nums, n);
        System.out.println("=========");
        Arrays.stream(retList).forEach(ele -> System.out.println(ele));
    }
}
