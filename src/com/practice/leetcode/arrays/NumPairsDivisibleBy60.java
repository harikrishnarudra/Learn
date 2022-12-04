package com.practice.leetcode.arrays;

public class NumPairsDivisibleBy60 {

    //BRUTE FORCE - N^2 Time complexity
    public int numPairsDivisibleBy60N2(int[] time) {
        int result = 0;
        int len = time.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if((time[i] + time[j])%60==0){
                    result++;
                }
            }
        }
        return result;
    }

    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int[] seen = new int[60];
        for(int t:time){
            count += seen[(60 -(t % 60)) % 60];
            seen[(t%60)] += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        NumPairsDivisibleBy60 n = new NumPairsDivisibleBy60();
        System.out.println(n.numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
        System.out.println(n.numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }
}
