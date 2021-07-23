package com.practice.hackerrank.interviewPrep.strings;

import java.util.HashMap;
import java.util.Map;

public class MakingAnagrams {

    public static int makeAnagram(String a, String b) {
        int result = 0;
        if (a == null && b != null) {
            return b.length();
        }
        if (a != null && b == null) {
            return a.length();
        }
        if (a != null && b != null) {
            char[] arr = a.toCharArray();
            String target = b;
            String src = a;
            if(a.length() > b.length()){
                arr = b.toCharArray();
                target = a;
                src=b;
            }

            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];
                int index = -1;
                if(map.containsKey(c)){
                    int prevInd = map.get(c);
                    index= target.indexOf(c, prevInd);

                }else {
                    index = target.indexOf(c);
                }
                if(index==-1){
                    src=src.replace(String.valueOf(c),"");
                    result+=1;
                }
                map.put(c, index);
            }
            result+=Math.abs(target.length()-src.length());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(makeAnagram("cde","dcf"));
        System.out.println(makeAnagram("bacdc", "dcbac"));
        System.out.println(makeAnagram("cde", "abc"));
        System.out.println(makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
    }
}
