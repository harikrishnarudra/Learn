package com.practice.learn;

import java.util.HashSet;
import java.util.Set;

public class Sibros {

    public int findMaxContArray(char[] arr){
        int n = arr.length;
        int maxSum = 0;
        if(n==0) return 0;
        if (n == 1) return 1;
        if(n>1){
            for(int i=0;i<n;i++){
                Set<Character> set = new HashSet<>(2);
                int subSum = 0;
                for(int j=i;j<n;j++){
                    if(set.contains(arr[j]) || set.size()<=1){
                        set.add(arr[j]);
                        subSum++;
                    }else{
                        break;
                    }
                }
                maxSum = Math.max(maxSum, subSum);
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        Sibros sol = new Sibros();
        System.out.println(sol.findMaxContArray(new char[]{'A', 'B', 'A', 'A', 'C', 'A', 'A'}));
    }
}
