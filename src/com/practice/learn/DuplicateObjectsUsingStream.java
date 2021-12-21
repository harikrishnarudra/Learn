package com.practice.learn;

import com.practice.model.Fruit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateObjectsUsingStream {

    private static void applyReduce(List<Fruit> fruits){
        List<Fruit> accFruits = new ArrayList<>();
        Fruit fruit = fruits.stream().reduce(fruits.get(0), (accumulatorFruit, nextElement) -> {
            if (accumulatorFruit.getColor().equals(nextElement.getColor())) {
                return accumulatorFruit;
            }
            accFruits.add(nextElement);
            return nextElement;
        });
//        System.out.println(fruit);

        accFruits.stream().forEach(System.out::println);
    }

    private static void removeDuplicates(List<Fruit> fruits) {
        ArrayList<Fruit> fruits1 = fruits.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() ->
                new TreeSet<>(Comparator.comparing(Fruit::getColor))), ArrayList::new));
        fruits1.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Fruit> list = List.of(new Fruit("Apple", "Red"),
                new Fruit("Guava", "Green"), new Fruit("Carrot", "Orange"),
                new Fruit("Apple2", "Green"));
        removeDuplicates(list);
    }
}
