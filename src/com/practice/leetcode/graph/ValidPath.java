package com.practice.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1971. Find if Path Exists in Graph
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 * You want to determine if there is a valid path that exists from vertex start to vertex end.
 * Given edges and the integers n, start, and end, return true if there is a valid path from start to end, or false otherwise.
 *
 * Example 1:
 *
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], start = 0, end = 2
 * Output: true
 * Explanation: There are two paths from vertex 0 to vertex 2:
 * - 0 → 1 → 2
 * - 0 → 2
 * Example 2:
 *
 * Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], start = 0, end = 5
 * Output: false
 * Explanation: There is no path from vertex 0 to vertex 5.
 *
 * Constraints:
 *
 * 1 <= n <= 2 * 105
 * 0 <= edges.length <= 2 * 105
 * edges[i].length == 2
 * 0 <= ui, vi <= n - 1
 * ui != vi
 * 0 <= start, end <= n - 1
 * There are no duplicate edges.
 * There are no self edges.
 */
public class ValidPath {

    private boolean seen;

    public void doDFS(int start, int end, List<List<Integer>> adjList, int[] visited) {
        visited[start] = 1;
        if(start == end){
            seen = true;
            return;
        }
        List<Integer> neighbors = adjList.get(start);
        for(int i=0; i<neighbors.size();i++){
            if(visited[neighbors.get(i)]==0){
                doDFS(neighbors.get(i), end, adjList, visited);
            }
        }
    }
    public boolean doBFS(int start, int end, List<List<Integer>> adjList, int n){
        int[] visited = new int[n];
        visited[start] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()){
            int dest = q.poll();
            if(dest == end) {
                return true;
            }
            if(dest != end){
                List<Integer> adjNodes = adjList.get(dest);
                for(int i=0;i<adjNodes.size();i++){
                    if(visited[adjNodes.get(i)]!=1){
                        q.add(adjNodes.get(i));
                        visited[adjNodes.get(i)] = 1;
                    }
                }
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int start, int end) {
        List<List<Integer>> adjList = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i< edges.length; i++){
            int[] edge = edges[i];
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
//        return doBFS(start, end, adjList, n);
        int[] visited = new int[n];
        seen = false;
        doDFS(start, end, adjList, visited);
        return seen;
    }

    public static void main(String[] args) {
        ValidPath v = new ValidPath();
        int [][] edges = new int[][]{{0, 1}, {1, 2},{2, 0}};
        System.out.println(v.validPath(3, edges, 0, 2));

        edges = new int[][]{{0, 1},{0, 2},{3, 5},{5, 4},{4, 3}};
        System.out.println(v.validPath(6, edges, 0, 5));

        edges = new int[][]{{2, 9}, {7, 8}, {5, 9}, {7, 2}, {3, 8}, {2, 8}, {1, 6}, {3, 0}, {7, 0}, {8, 5}};
        System.out.println(v.validPath(10, edges, 1, 0));
    }
}
