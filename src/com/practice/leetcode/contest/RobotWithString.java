package com.practice.leetcode.contest;


import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class RobotWithString {

    public String robotWithString(String s) {
        Map<Character, List<Integer>> map = new TreeMap<>();
        final char[] chars = s.toCharArray();
        for(int i=0;i<s.length();i++){
            List<Integer> set = map.getOrDefault(chars[i], new ArrayList<>());
            set.add(i);
            map.put(chars[i], set);
        }
        int k=0;
        int[] arr = new int[s.length()];
        for(Map.Entry entry:map.entrySet()){
            ArrayList<Integer> set = (ArrayList<Integer>) entry.getValue();
            for(int i=set.size()-1;i>=0;i--){
                arr[k++] = set.get(i);
            }
        }
        int prevIndex = 0; StringBuilder resStr = new StringBuilder();
        StringBuilder tStr = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            int index = arr[i];
            if(index >= prevIndex) {
                StringBuilder sub = new StringBuilder();
                sub.append(s, prevIndex, index);
                tStr.append(sub);
                resStr.append(s.charAt(arr[i]));
                prevIndex = arr[i] + 1;
                if (index == s.length() - 1) {
                    break;
                }
            }
        }
        resStr.append(tStr.reverse());
        return resStr.toString();
    }



    public String robotWithString2(String s) {
        int i=0,j=1,prevInd=0, len = s.length();
        StringBuilder res = new StringBuilder();
        while(i < len){
            StringBuilder sb = new StringBuilder();
            while(j < len && s.charAt(i) >= s.charAt(j) ){
                sb.append(s.charAt(i));
                i++;
                j++;
            }
            sb.append(s.charAt(i));
            i++;
            j++;
            sb.reverse();

            if( res.length()>0 && sb.charAt(0) < res.charAt(0)){
                sb.append(res);
                res = sb;
            }else {
                res.append(sb);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        RobotWithString r = new RobotWithString();
//        System.out.println(r.robotWithString("bydizfve"));

        System.out.println(r.robotWithString("bac"));
        System.out.println(r.robotWithString("baac"));
        System.out.println(r.robotWithString("zza"));
        System.out.println(r.robotWithString("bdda"));
        System.out.println(r.robotWithString("a"));
        System.out.println(r.robotWithString("az"));
        System.out.println(r.robotWithString("zaz"));
        System.out.println(r.robotWithString("zbbzaa"));

    }
}
