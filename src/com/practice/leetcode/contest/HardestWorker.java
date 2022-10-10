package com.practice.leetcode.contest;

public class HardestWorker {
    public int hardestWorker(int n, int[][] logs) {
        int prevUnit = 0, maxTime=0, employee = -1;
        for(int i=0;i< logs.length;i++){
            int[] arr = logs[i];
            int val = arr[1] - prevUnit;
            if(val > maxTime){
                maxTime = val;
                employee = arr[0];
            }
            if (val == maxTime) {
                employee = arr[0] < employee ? arr[0] : employee;
            }
            prevUnit = arr[1];
        }
        return employee;
    }

    public static void main(String[] args) {
        HardestWorker h  = new HardestWorker();
        System.out.println(h.hardestWorker(10, new int[][]{{0, 10}, {1, 20}}));
        System.out.println(h.hardestWorker(10, new int[][]{{0, 3}, {2, 5},{0,9},{1,15}}));
        System.out.println(h.hardestWorker(26, new int[][]{{1, 1}, {3, 7},{2, 12},{7, 17}}));
    }

}
