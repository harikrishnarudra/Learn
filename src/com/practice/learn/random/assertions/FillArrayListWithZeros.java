package com.practice.learn.random.assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FillArrayListWithZeros {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(5);
        a.add(1);a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        Collections.fill(a, 4);
        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i));
        }

        ArrayList<Integer> zeroRow = new ArrayList<Integer>(Collections.nCopies(5, 0));
        for (int i = 0; i < zeroRow.size(); i++) {
            System.out.println(zeroRow.get(i));
        }

        Integer[] data = new Integer[5];
        Arrays.fill(data, new Integer(0));
        List<Integer> list = Arrays.asList(data);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
