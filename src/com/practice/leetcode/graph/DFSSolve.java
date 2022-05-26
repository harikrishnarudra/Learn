package com.practice.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class DFSSolve {
    public void dfs(int node, int[] visited, List<ArrayList<Integer>> edges){
        visited[node] = 1;
        System.out.println(node);
        List<Integer> neighbors = edges.get(node);
        for(int k:neighbors){
            if(visited[k]==0){
                dfs(k, visited, edges);
            }
        }
    }

    public void solveDFS(int n, int m, List<ArrayList<Integer>> edges, int[] visited){
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i, visited, edges);
            }
        }
    }

    private static void printAdjList(List<ArrayList<Integer>> adjList) {
        for(int i=0;i<adjList.size();i++){
            System.out.println("i= "+i);
            ArrayList<Integer> intList = adjList.get(i);
            System.out.print("Neighbors= ");
            for(int j=0;j<intList.size(); j++){
                System.out.print(intList.get(j)+" ");
            }
            System.out.println(" ");
        }
    }


    private static void addEdge(List<ArrayList<Integer>> adjList, int u, int v){
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public static void main(String[] args) {
        int n = 6, m = 5; // 0-based
        n=6+1; m=5+1; // 1-based
//        int[][] edges = new int[][]{{0,1}, {0, 2},{3, 5},{5, 4},{4, 3}};
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 5}, {5, 1}, {4, 6}};
        //Create an Adjacency list
        List<ArrayList<Integer>> adjList = new ArrayList<>(n);
        for(int i=0;i<=m;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i< edges.length;i++){
            int[] edge = edges[i];
            addEdge(adjList, edge[0],edge[1]);
        }
        printAdjList(adjList);
        int[] visited = new int[n];
        DFSSolve d = new DFSSolve();
        d.solveDFS(n,m, adjList, visited);
    }
}
