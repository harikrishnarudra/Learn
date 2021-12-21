package com.practice.learn;

import com.practice.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class BuildCollectionFromObjects {

    public static void main(String[] args) {
        List<Fruit> list = List.of(new Fruit("Apple", "Red"),
                new Fruit("Guava", "Green"), new Fruit("Carrot", "Orange"));
        List<String> fruits = new ArrayList<>();
        List<String> colors = new ArrayList<>();
        list.stream().forEach(fruit -> {
            fruits.add(fruit.getFruitName());
            colors.add(fruit.getColor());
        });
        fruits.stream().forEach(System.out::println);
        colors.stream().forEach(System.out::println);
    }
}
