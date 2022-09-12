package com.practice.learn;

import com.practice.model.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectTwoLists {
    private void streamIterate(List<Fruit> fruits) {
        fruits.stream()
                .forEach(fruit -> doSomething(fruit));
    }

    private void streamIterate2(List<Fruit> fruits){
        fruits.stream().map(fruit -> doSomethingElse(fruit)).collect(Collectors.toList());
//                .forEach(fruit -> doSomething(fruit));
    }
    private void doSomething(Fruit fruit){
        System.out.println(fruit.getColor());
    }

    private Fruit doSomethingElse(Fruit fruit) {
        System.out.println(fruit.getColor());
        return fruit;
    }

    private List<Fruit> doSomethingElse2(List<Fruit> fruits) {
        for(Fruit fruit:fruits) {
            System.out.println(fruit.getColor());
        }
        return fruits;
    }


    public static void main(String[] args) {
        List<Fruit> list = List.of(new Fruit("Apple", "Green"),
                new Fruit("Guava", "Green"), new Fruit("Carrot", "Orange"),
                new Fruit("Apple2", "Green"));
        StreamCollectTwoLists s = new StreamCollectTwoLists();
        s.streamIterate(new ArrayList<>());
    }
}
