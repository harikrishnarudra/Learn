package com.practice.learn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringSort {
    public static void main(String[] args) {
        String arr[] = new String[] {"abc", "10","2", "0"};
        List<String> list = Arrays.asList(arr);
        Collections.sort(list);
        for (String s:list) {
            System.out.println(s);
        }
    }
}
