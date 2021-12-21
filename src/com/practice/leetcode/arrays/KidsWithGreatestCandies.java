package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class KidsWithGreatestCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>(candies.length);
        int max = Integer.MIN_VALUE;
        for(int i:candies){
            if(i>max){
                max=i;
            }
        }
        //int max = Arrays.stream(candies).max().getAsInt();
        for(int i:candies){
            if(i+extraCandies >= max){
                res.add(true);
            }
            else {
                res.add(false);
            }
        }
        return res;
    }

    public List<Boolean> kidsWithCandiesWithStreams(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        return Arrays
                .stream(candies)
                .mapToObj(a->a+extraCandies >=max)
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        KidsWithGreatestCandies k = new KidsWithGreatestCandies();
        List<Boolean> booleans = k.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3);
        booleans.forEach(System.out::println);
    }
}
