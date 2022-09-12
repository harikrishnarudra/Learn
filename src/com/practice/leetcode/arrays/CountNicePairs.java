package com.practice.leetcode.arrays;

import com.practice.leetcode.contest.CountExcellentPairs;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairs {
    public int countNicePairs(int[] A) {
        int res = 0, mod = (int) 1e9 + 7; //1000000007, in the question its clearly mentioned that we need to mod of 1000000007
        Map<Integer, Integer> count = new HashMap<>();
        ;
        for (int a : A) {
            int b = rev(a), v = count.getOrDefault(a - b, 0);
            count.put(a - b, v + 1);
            res = (res + v) % mod;
        }
        return res;

    }

    private int rev(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        CountNicePairs cn = new CountNicePairs();
        System.out.println(cn.countNicePairs(new int[]{352171103, 442454244, 42644624, 152727101, 413370302, 293999243}));
    }

}
