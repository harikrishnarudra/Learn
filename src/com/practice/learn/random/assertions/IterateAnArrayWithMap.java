package com.practice.learn.random.assertions;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IterateAnArrayWithMap {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        Logger logger = Logger.getLogger("IterateAnArrayWithMap");
        List<Integer> collect = Arrays.stream(arr).mapToObj(i -> i * i).collect(Collectors.toList());


        Arrays.stream(arr).forEach(System.out::println);
        collect.forEach(System.out::println);

        IntStream.of(arr).mapToLong(i->i).sum();
        Arrays.stream(arr).mapToLong(i -> i).sum();
        List<Integer> list = List.of(1,2,3,4);
        Flux.fromIterable(list).map(i -> i)
                .doOnNext(i -> System.out.println("next element received: " + i))
                .doOnError(error -> new IllegalArgumentException())
                .doOnComplete(()-> System.out.println("completed"))
                .subscribe();
    }

}
