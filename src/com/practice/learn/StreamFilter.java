package com.practice.learn;

import com.practice.model.Fruit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamFilter {

    private static void withFlux(List<Fruit> fruits){
        Mono<List<String>> stringFlux = Flux.fromIterable(fruits)
                .filter(fruit -> fruit.getFruitName().equalsIgnoreCase("carrot2"))
                .map(fruit -> fruit.getColor())

//                .map(filteredFruits -> filteredFruits.get(0))
//                .switchIfEmpty(Mono.defer(() -> Mono.just("no color")));
        .switchIfEmpty(Flux.defer(() -> Flux.just("no color"))).collectList();
        stringFlux.block().forEach(s -> System.out.println(s));
//        System.out.println(stringFlux.block());
    }

    private static Fruit collectionsMin(List<Fruit> fruits){
        return Collections.min(fruits, Comparator.comparing(fruit -> fruit.getColor()));
    }

    private static void  streamFilter(List<Fruit> fruits){
        boolean exists = fruits.stream()
                .anyMatch(fruit -> fruit.getColor().equalsIgnoreCase("REDu"));
        System.out.println(exists);
        List<Fruit> empList = null;
        System.out.println(empList.size());
        System.out.println(empList.isEmpty());
        System.out.println(empList.stream().findFirst().orElse(null));
        if (null instanceof String) {
            System.out.println("test");
        } else {
            System.out.println("test2");
        }
    }

    public static void main(String[] args) {
        List<Fruit> list = List.of(new Fruit("Apple", "Green"),
                new Fruit("Guava", "Green"), new Fruit("Carrot", "Orange"),
                new Fruit("Apple2", "Green"));
//        withFlux(list);
//        streamFilter(list);
        System.out.println(collectionsMin(list));
    }
}
