package com.practice.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSSolve {

    private void bfs(int node, List<List<Integer>> adjList, int[] visited) {
        System.out.println(node);
        visited[node] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()){
            int ele = q.poll();
            List<Integer> neighbors = adjList.get(ele);
            for(int i=0;i<neighbors.size();i++){
                if(visited[neighbors.get(i)]==0){
                    System.out.println(neighbors.get(i));
                    visited[neighbors.get(i)] = 1;
                    q.add(neighbors.get(i));
                }
            }
        }
    }

    private void bfsSolve(List<List<Integer>> adjList, int[] visited){
        for(int i=0; i<adjList.size();i++){
            if(visited[i]==0){
                bfs(i, adjList, visited);
            }
        }
    }

    private static void addEdge(List<List<Integer>> adjList, int u, int v){
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3},{1,3}, {2,5}};
//        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 5}, {5, 1}, {4, 6}};
        //Create an Adjacency list
        List<List<Integer>> adjList = new ArrayList<>(n);
        for(int k=0;k<n;k++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i< edges.length;i++){
            int[] edge = edges[i];
            addEdge(adjList, edge[0], edge[1]);
        }
        int[] visited = new int[n];
        BFSSolve b = new BFSSolve();
        b.bfsSolve(adjList, visited);
    }
}
