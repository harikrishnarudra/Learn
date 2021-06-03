package com.test.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private Map<Integer, Long> map = new HashMap<Integer, Long>();

    public long fib(int n){
        if (map.containsKey(n)){
            return map.get(n);
        }
        if(n<=2){
            return 1;
        }
        map.put(n,fib(n-1)+fib(n-2));
        return map.get(n);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(6));
        System.out.println(fibonacci.fib(7));
        System.out.println(fibonacci.fib(8));
        System.out.println(fibonacci.fib(50));
    }
}
