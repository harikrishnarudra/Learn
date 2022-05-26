package com.practice.interviewBit;

public class MaxMin {
    public int solve(int[] A) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for(int e:A){
            if(e < minVal){
                minVal = e;
            }
            if (e > maxVal) {
                maxVal = e;
            }
        }
        return maxVal+minVal;
    }

    public static void main(String[] args) {
        MaxMin m = new MaxMin();
        System.out.println(m.solve(new int[]{-2, 1, -4, 5, 3}));
        System.out.println(m.solve(new int[]{1, 3, 4, 1}));
        System.out.println(m.solve(new int[]{1, 1}));
    }
}
