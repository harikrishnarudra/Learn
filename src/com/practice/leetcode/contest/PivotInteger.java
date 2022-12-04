package com.practice.leetcode.contest;

public class PivotInteger {
    public int pivotInteger(int n) {
        int total = (n*(n+1))/2;
        int prev = 0;
        for(int i=n;i>=0;i--){
            total -= i;
            if(total == prev){
                return i;
            }
            prev += i;
        }
        return -1;
    }

    public static void main(String[] args) {
        PivotInteger p = new PivotInteger();
        System.out.println(p.pivotInteger(8));
        System.out.println(p.pivotInteger(1));
        System.out.println(p.pivotInteger(4));
    }
}
