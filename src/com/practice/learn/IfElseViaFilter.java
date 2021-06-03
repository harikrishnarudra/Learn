package com.test.learn;

import com.test.model.Fruit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class IfElseViaFilter {
    public static void main(String[] args) {
        List<Fruit> list = new ArrayList<Fruit>();
        list.add(new Fruit("Apple","Red"));
        list.add(new Fruit("Guava", "Green"));
        list.add(new Fruit("Carrot", "Orange"));
        list.add(new Fruit("Pumpkin", "Red"));
        list.add(new Fruit("Grape", "Green"));

        //Flux<List<String>> eles = Flux.just(list);
        Mono<List<Fruit>> listMono = Flux.fromIterable(list)
                .flatMap(ele -> {
                    if (isFruitObj(ele)) {
                        System.out.println("fruit " + ele.getFruitName());
                        ele.setColor("Green");
                    } else {
                        System.out.println("Not a fruit " + ele.getFruitName());
                        ele.setColor("Veg color");
                    }
                    return Mono.just(ele);
                })
                .collectList();
        listMono.block().stream().forEach(System.out::println);
    }

    private static boolean isFruitObj(Fruit val) {
        if (val.getFruitName().equalsIgnoreCase("Apple") || val.getFruitName().equalsIgnoreCase("Guava")
                || val.getFruitName().equalsIgnoreCase("Grape")) {
            return true;
        }
        return false;
    }
    private static boolean isFruit(String val){
        if (val.equalsIgnoreCase("Apple") || val.equalsIgnoreCase("Guava")
            || val.equalsIgnoreCase("Grape")){
            return true;
        }
        return false;
    }

    private static void printEle(String val){
        System.out.println(val);
    }

    private static void doOther(String val) {
        return;
    }
}
