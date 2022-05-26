package com.practice.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    public int findWordLadder(String start, String end, List<String> words){
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int changes = 1;
        q.add(start);
        set.add(start);
        while (!q.isEmpty()){
            String qEle = q.remove();
            if (qEle.equals(end)) return changes;
            char[] arr = qEle.toCharArray();
            for(int i=0; i<arr.length;i++){
                for(char c='a'; c<='z';c++){
                    String replace = qEle.replace(arr[i], c);
                    if(words.contains(replace) && !set.contains(replace)){
                        q.add(replace);
                        set.add(replace);
                    }
                }
            }
            changes++;
        }
        return changes;
    }


    public static void main(String[] args) {
        WordLadder w = new WordLadder();
        System.out.println(w.findWordLadder("be", "ko", List.of("ce", "mo", "ko", "me", "co")));
    }
}
