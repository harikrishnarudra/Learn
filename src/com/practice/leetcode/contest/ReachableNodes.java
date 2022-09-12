package com.practice.leetcode.contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReachableNodes {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer> list = Arrays.stream(restricted).boxed().collect(Collectors.toList());
        Set<Integer> set = new HashSet<>();
        Set<Integer> unreachable = new HashSet<>(list);
        set.add(0);
        for (int[] edge : edges) {
            if (list.contains(edge[0]) || list.contains(edge[1])) {
                unreachable.add(edge[0]);
                unreachable.add(edge[1]);
            }
            else {
                set.add(edge[0]);
                set.add(edge[1]);
            }
        }
        unreachable.remove(0);
        int res = 0;
        for(int i:set){
            if(!unreachable.contains(i)){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ReachableNodes r = new ReachableNodes();
        /*System.out.println(r.reachableNodes(7, new int[][]{{0, 1},{0, 2},{0, 5},{0, 4},{3, 2},{6, 5}}, new int[]{4,2,1}));
        System.out.println(r.reachableNodes(2, new int[][]{{0, 1}}, new int[]{1}));
        System.out.println(r.reachableNodes(10, new int[][]{{8, 2}, {2, 5}, {5, 0}, {2, 7}, {1, 7}, {3, 8}, {0, 4}, {3, 9}, {1, 6}}, new int[]{9,8,4,5,3,1}));*/
        System.out.println(r.reachableNodes(4, new int[][]{{2, 1}, {1, 0}, {3, 0}}, new int[]{3, 2}));
    }
}
