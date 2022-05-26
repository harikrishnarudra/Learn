package com.practice.learn.random.assertions;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestSeven extends Thread{
    private static int x;
    public synchronized void doThings(){
        int c =x;
        c++;
        x = c;
    }
    public void run(){
        System.out.println("test");
//        doThings();
    }

    public static void main(String[] args) {
        /*TestSeven s = new TestSeven();
        s.setDaemon(false);
        s.start();
        s.setDaemon(true);
*/
        List<List<String>> list1 = List.of(List.of("A","B"), List.of("A2", "A3"), List.of("B"));
        List<String> list2 = list1.stream().flatMap(name -> name.stream())
                .filter(s2->s2.startsWith("A")).collect(Collectors.toList());

         list2.stream().forEach(System.out::println);

         List<String> l = Collections.EMPTY_LIST;
        System.out.println(l.stream().filter(s -> s.equalsIgnoreCase("t")).findFirst().orElse(null));
//        System.out.println(r.orElse(null));
    }
}
