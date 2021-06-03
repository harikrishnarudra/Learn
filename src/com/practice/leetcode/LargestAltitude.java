package com.test.leetcode;

//1732. Find the Highest Altitude

public class LargestAltitude {
    public int largestAltitudeV2(int[] gain) {
        int max = 0;
        int prevVal = 0;
        for (int i=0; i<gain.length; i++){
            int currVal = gain[i]+prevVal;
            if (currVal > max){
                max = currVal;
            }
            prevVal = currVal;
        }
        return max;
    }

    public int largestAltitude(int[] gain) {
        int max = 0, prevVal = 0;
        for (int i = 0; i < gain.length; i++) {
            int currVal = gain[i] + prevVal;
            max = Math.max(currVal, max);
            prevVal = currVal;
        }
        return max;
    }

    public static void main(String[] args) {
        LargestAltitude largestAltitude = new LargestAltitude();
        System.out.println(largestAltitude.largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
        System.out.println(largestAltitude.largestAltitude(new int[]{-5, 1, 5, 0, -7}));
        System.out.println(largestAltitude.largestAltitude(new int[]{}));
        System.out.println(largestAltitude.largestAltitude(new int[]{5}));
    }
}
