package com.practice.interviewBit;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class OccurenceOfEachNumber {
    public int[] findOccurences(int[] A) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i:A){
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i)+1);
        }
        return map.values().stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        OccurenceOfEachNumber o = new OccurenceOfEachNumber();
        int[] res = o.findOccurences(new int[]{4,3,3});
        Arrays.stream(res).forEach(System.out::println);
    }
}
