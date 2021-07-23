package com.practice.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListsEquality {

    public static void equalsMethod(List<String> l1, List<String> l2){
        System.out.println("By equal "+l1.equals(l2));
    }

    public static void equalsMethodSort(List<String> l1, List<String> l2) {
        Collections.sort(new ArrayList<String>(l1));
        Collections.sort(new ArrayList<String>(l2));
        System.out.println("By equal after sorting " + l1.equals(l2));
    }

    public static void containsAll(List<String> l1, List<String> l2) {
        Collections.sort(new ArrayList<String>(l1));
        Collections.sort(new ArrayList<String>(l2));
        System.out.println("By contains all  " + l1.containsAll(l2));
    }

    public static void withStreams(List<String> l1, List<String> l2) {
        if(l1.size() == l2.size()) {
            List<String> collect = l1.stream().filter(ele -> !l2.contains(ele))
                    .collect(Collectors.toList());
            System.out.println("By streams " + collect.isEmpty());
        }
    }

    public static void withSet(List<String> l1, List<String> l2) {
        Set s1 = new HashSet(l1);
        Set s2 = new HashSet(l2);
        s1.removeAll(s2);
        System.out.println("By Set " + s1.isEmpty());
        System.out.println("By Set " + s2.isEmpty());
    }

    public static void main(String[] args) {
        List<String> list1 = List.of("fascinating","pleasing","lovesome", "excellent");
        List<String> list2 = List.of("excellent", "lovesome", "pleasing", "fascinating");
        equalsMethod(list1,list2);
        equalsMethodSort(list1, list2);
        containsAll(list1, list2);
        withStreams(list1, list2);
        withSet(list1, list2);
    }
}
