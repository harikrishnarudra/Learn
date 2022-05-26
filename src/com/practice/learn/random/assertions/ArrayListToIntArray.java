package com.practice.learn.random.assertions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListToIntArray {
    //Java 8
    public void convertArrayListToArray(List<Integer> list) {
        int[] arr = list.stream().mapToInt(i->i).toArray();
        int[] primitive = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
