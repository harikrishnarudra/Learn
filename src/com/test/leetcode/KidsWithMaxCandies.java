package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.Objects.nonNull;

public class KidsWithMaxCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<Boolean>(candies.length);
        if (nonNull(candies) && candies.length>0) {
            int max = candies[0];
            for (int candy : candies) {
                if (candy >= max) {
                    max = candy;
                }
            }
            int finalMax = max;
            Arrays.stream(candies).forEach(value -> {
                if (value + extraCandies >= finalMax) {
                    result.add(true);
                } else {
                    result.add(false);
                }
            });
        }
        return result;
    }

    public static void main(String[] args){
        KidsWithMaxCandies kidsWithMaxCandies = new KidsWithMaxCandies();
        System.out.println(kidsWithMaxCandies.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
    }
}
