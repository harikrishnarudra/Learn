package com.practice.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsSort {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(1);
        Collections.sort(list, (a,b) -> a-b);
        list.forEach(System.out::println);
        Collections.sort(list, (a, b) -> b - a);
        list.forEach(System.out::println);
    }
}
