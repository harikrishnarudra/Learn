package com.practice.learn;

import com.practice.model.Fruit;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SplitList {

    static void splitIntegers(){
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        Map<Boolean, List<Integer>> groups =
                intList.stream().collect(Collectors.partitioningBy(s -> s > 6));
        List<List<Integer>> subSets = new ArrayList<List<Integer>>(groups.values());
        List<Integer> firstPartition = subSets.get(0);
        List<Integer> lastPartition = subSets.get(1);
        System.out.println("-- first partition -- ");
        firstPartition.stream().forEach(System.out::println);
        System.out.println("-- last partition -- ");
        lastPartition.stream().forEach(System.out::println);
    }

    static void splitObjects() {
        List<Fruit> list = List.of(new Fruit("Apple", "Red"),
                new Fruit("Guava", "Green"), new Fruit("Carrot", "Orange"));

        Map<Boolean, List<Fruit>> groups = list.stream().collect(Collectors.partitioningBy(s -> s.getFruitName().equalsIgnoreCase("apple")));
        List<List<Fruit>> subSets = new ArrayList<List<Fruit>>(groups.values());
        List<Fruit> firstPartition = subSets.get(0);
        List<Fruit> lastPartition = subSets.get(1);
        System.out.println("-- first partition -- ");
        firstPartition.stream().forEach(System.out::println);
        System.out.println("-- last partition -- ");
        lastPartition.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        splitIntegers();
        splitObjects();

    }
}
