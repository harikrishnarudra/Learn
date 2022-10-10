package com.practice.leetcode.contest;

import java.util.Arrays;

public class FindXORArray {
    public int[] findArray(int[] pref) {
        int leng = pref.length;
        int[] result = new int[leng];
        result[0] = pref[0];
        int prev = pref[0];
        for(int i=1;i<leng;i++){
            result[i] = prev ^ pref[i];
            prev = prev ^ result[i];
        }
        return result;
    }

    public static void main(String[] args) {
        FindXORArray f = new FindXORArray();
        int[] res = f.findArray(new int[]{5,2,0,3,1});
        Arrays.stream(res).forEach(System.out::println);
        System.out.println("======");
        res = f.findArray(new int[]{5});
        Arrays.stream(res).forEach(System.out::println);
    }
}
