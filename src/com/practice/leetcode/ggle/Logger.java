package com.practice.leetcode.ggle;

import java.util.HashMap;
import java.util.Map;

public class Logger {
    private Map<String, Integer> map;
    public Logger(){
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean result = false;
        if(map.containsKey(message)){
            result = timestamp >= map.get(message);
            if(result){
                map.put(message, timestamp + 10);
            }
        }else{
            map.put(message, timestamp+10);
            result = true;
        }
        return result;
    }
}

class Solution{
    public static void main(String[] args) {
        Logger l = new Logger();
        System.out.println(l.shouldPrintMessage(1, "f00"));
        System.out.println(l.shouldPrintMessage(2, "bar"));
        System.out.println(l.shouldPrintMessage(3, "f00"));
        System.out.println(l.shouldPrintMessage(8, "bar"));
        System.out.println(l.shouldPrintMessage(10, "f00"));
        System.out.println(l.shouldPrintMessage(11, "f00"));
        System.out.println(l.shouldPrintMessage(12, "f00"));
        System.out.println(l.shouldPrintMessage(22, "f00"));



    }
}
