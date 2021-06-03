package com.practice.learn;

import reactor.core.publisher.Mono;

import java.util.List;

public class TestSwitchIfEmpty {

    public static void main(String[] args) {
        List listOfWords = List.of("This", "is", "switchIfEmpty", "test");
        TestSwitchIfEmpty testSwitchIfEmpty = new TestSwitchIfEmpty();
        Mono<String> retVal = testSwitchIfEmpty.doSomeOperation(listOfWords);
        System.out.println(retVal.block());
    }

    private Mono<String> doSomeOperation(List<String> listOfWords){
        return Mono.just(listOfWords)
                .filter(list -> list.contains("isss"))
                //.map(exists -> exists)
                //.switchIfEmpty( Mono.defer(()->firstSwitch()))
                .flatMap(bool1 -> doSomeOperation1())
                .filter(retString -> retString.equalsIgnoreCase("Yes it is ss"))
                .flatMap(nextOp -> doSomeOperation2())
                .switchIfEmpty(Mono.defer(()->secondSwitch()));
    }

    private Mono<String> doSomeOperation1() {
        System.out.println("Am in doSomeOperation1 - In");
        return Mono.just("Yes it is");
    }

    private Mono<String> doSomeOperation2() {
        System.out.println("Am in doSomeOperation2 - Not");
        return Mono.just("Yes it is not");

    }
    private Mono<List<String>> firstSwitch(){
        System.out.println("Am in first switch");
        List fsList = List.of("first", "switch");
        return Mono.just(fsList)
                .filter(fsList1 -> fsList1.contains("first"))
                .map(fsList2 -> fsList2);


    }

    private Mono<String> secondSwitch() {
        System.out.println("Am in Second switch");
        List<String> fsList = List.of("second", "switch");
        return Mono.just(fsList)
                .filter(fsList1 -> fsList1.contains("second"))
                .map(fsList2 -> fsList2.get(0));


    }
}
