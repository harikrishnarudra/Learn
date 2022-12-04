package com.practice.leetcode.contest;

public class SubArrayGCD {

    public int subarrayGCD(int[] nums, int k) {
        int count = 0, prevInd = -1, i=0;
        for(int j=0;j<nums.length;j++){
            while (i < nums.length && nums[i] % k == 0) {
                prevInd = prevInd == -1 ? i : prevInd;
                i++;
            }
            if (i >= prevInd ) {
                /*if(i== nums.length){
                    i = i-1;
                }*/
                int sc = findMatrices(nums, prevInd, --i, k);
                count += sc;
                prevInd = -1;
            }
            j += i;

            /*if(nums[i]%k==0){
                *//*if(nums[i] == k){
                    count++;
                }*//*
                prevInd = prevInd==-1?i:prevInd;
                if(i>= prevInd){
                    int sc = findMatrices(nums, prevInd, i, k);
                    count += sc;
                }
            }else{
                prevInd = -1;
            }*/
        }
        return count;
    }

    private int findMatrices(int[] nums, int prevInd, int i, int k){
        int subCount = 0;
        int m = i-1;
        while(m > prevInd){
            if (arrayGCD(nums, prevInd, m, k)) {
                subCount++;
            }
            m--;
        }
        while(prevInd <= i){
            if(arrayGCD(nums, prevInd, i, k)){
                subCount++;
            }
            prevInd += 1;
        }
        return subCount;
    }

    private boolean arrayGCD(int[] nums, int prevInd, int currInd, int givenK){
        int min = nums[prevInd], max = nums[prevInd];
        for(int i=prevInd; i<=currInd; i++){
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        return givenK==gcd(min, max);
    }
    private int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        SubArrayGCD s = new SubArrayGCD();
//        System.out.println(s.subarrayGCD(new int[]{9, 3, 1, 2, 6, 3}, 3));
        System.out.println(s.subarrayGCD(new int[]{4}, 7));
//        System.out.println(s.subarrayGCD(new int[]{4}, 4));
//        System.out.println(s.subarrayGCD(new int[]{54, 18, 1, 2, 9, 6, 3}, 3));
//        System.out.println(s.subarrayGCD(new int[]{3,12, 9, 6}, 3));
    }
}
