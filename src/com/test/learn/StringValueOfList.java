package com.test.learn;

import com.test.model.Fruit;

import java.util.Arrays;
import java.util.List;

public class StringValueOfList {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Pears");
        System.out.println(String.valueOf(fruits));

        List<Fruit> list = List.of(new Fruit("Apple", "Red"),
                new Fruit("Guava", "Green"), new Fruit("Carrot", "Orange"));
        System.out.println(String.valueOf(list));
    }
}
