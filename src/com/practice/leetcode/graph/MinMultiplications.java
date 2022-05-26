package com.practice.leetcode.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MinMultiplications {

    private int findMinimumMoves(int start, int end, int[] arr){
        int n = arr.length;
        int[] visited = new int[end+1];
        visited[start] = 1;
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(List.of(start, 0));
        while (!q.isEmpty()){
            List<Integer> poll = q.poll();
            int node = poll.get(0);
            int steps = poll.get(1);
            if(node == end){
                return steps;
            }
            for(int i=0;i<n;i++){
                int dest = node * arr[i];
                if(dest <= end && visited[dest]!=1){
                    q.add(List.of(dest, steps + 1));
                    visited[node] = 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int start =3, end =30;
        start = 2;
        end = 100;
        int[] arr = new int[]{2,5,10};
        MinMultiplications m = new MinMultiplications();
        System.out.println(m.findMinimumMoves(start, end, arr));
    }
}
