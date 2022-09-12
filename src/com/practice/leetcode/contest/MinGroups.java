package com.practice.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

public class MinGroups {
    public int minGroups(int[][] intervals) {
        List<List<Integer>> list = new ArrayList();

        for (int[] arr : intervals) {
            int left = arr[0];
            int right = arr[1];
            List<Integer> l = new ArrayList();
            boolean isAddedToExistingList = false;
            for (int i = 0; i < list.size(); i++) {
                l = list.get(i);
                if (!((left > l.get(0) && left < l.get(1)) && (right > l.get(0) && right < l.get(1)))) {
                    l.add(0, Math.min(l.get(0), left));
                    l.add(1, Math.max(l.get(1), right));
                    isAddedToExistingList = true;
                }
            }
            if(!isAddedToExistingList){
                l = new ArrayList();
                l.add(left);
                l.add(right);
                list.add(l);
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{5, 10},{6, 8}, {1, 5}, {2, 3}, {1, 10}};
        MinGroups m = new MinGroups();
        System.out.println(m.minGroups(arr));
    }
}
