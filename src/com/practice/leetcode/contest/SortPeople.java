package com.practice.leetcode.contest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class SortPeople {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Map<Integer, String> map = new TreeMap();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        String[] values = new String[n];
        map.values().toArray(values);
        String[] result = new String[n];
        int j = n-1;
        for(int i=0;i< n; i++){
            result[j--] = values[i];
        }
        return result;
    }

    public static void main(String[] args) {
        SortPeople sortPeople = new SortPeople();
        final String[] strings = sortPeople.sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170});
        Arrays.stream(strings).forEach(System.out::println);
    }
}
