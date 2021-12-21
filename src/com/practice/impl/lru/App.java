package com.practice.impl.lru;

public class App {
    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2();
        cache.put(0, "A");
        cache.put(1, "B");
        cache.put(2, "C");
        cache.put(3, "D");
        cache.put(4, "E");
        cache.put(5, "F");

        cache.show();
        Node node = cache.get(3);
        System.out.println("");
        System.out.println(node);
        cache.show();
        cache.get(0);
        System.out.println("");

        cache.show();
        cache.get(5);
        System.out.println("");
        cache.show();

        cache.put(6,"G");
        System.out.println("");
        cache.show();

    }
}
