package com.practice.leetcode.contest;

import java.util.HashMap;
import java.util.Map;

public class DecodeMsg {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap();
        char init = 'a';
        for(char c:key.toCharArray()){
            if(c != ' ' && !map.containsKey(c)) {
                map.put(c, init);
                init += 1;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(char d:message.toCharArray()){
            stringBuilder.append(map.getOrDefault(d,d));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        DecodeMsg d = new DecodeMsg();
//        System.out.println(d.decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
        System.out.println(d.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
    }
}
