package com.practice.leetcode.interviewExperience;

import java.time.Instant;

/**
 * DONT USE THIS. BETTER VERSION IS com.practice.interviewBit.PickFromBothSidesOfArray
 */
public class MaxKCornerElements {

    //BAD - TC - O(K^2)
    public int maxKCorner(int[] nums, int k){
        int leng = nums.length;
        int max = -1;
        if(leng > k){
            for(int i=k;i>=0;i--){
                int sum = 0;
                for(int j=0;j<k;j++){
                    sum += nums[(leng-i+j)%leng];
                }
                if(max < sum){
                    max=sum;
                }
            }
        }
        return max;
    }

/* From GFG, an efficient linear solution O(K)
    https://www.geeksforgeeks.org/maximize-sum-of-k-elements-in-array-by-taking-only-corner-elements/
 */
    public int maxKCornerGFG(int[] nums, int k) {
        int size = nums.length;
        int max=0, curr_sum=0;
        for(int i=0;i<k;i++){
            curr_sum += nums[i];
        }
        max = curr_sum;
        int j=size-1;
        for(int i=k-1;i>=0;i--){
            curr_sum = curr_sum+nums[j]-nums[i];
            if(curr_sum>max){
                max=curr_sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxKCornerElements maxKCornerElements = new MaxKCornerElements();
        long startTime = Instant.now().toEpochMilli();
        int k=3;
        System.out.println(maxKCornerElements.maxKCorner(new int[]{100,200,1,2,3,4,5,101}, k));
        System.out.println(maxKCornerElements.maxKCorner(new int[]{1, 2, 105, 4, 5, 6, 7}, k));
        System.out.println(maxKCornerElements.maxKCorner(new int[]{100, 200, 105, 4000, 500, 60, 7}, k));
        System.out.println("Time taken:"+ (Instant.now().toEpochMilli() - startTime));
        System.out.println("--------");
        startTime = Instant.now().toEpochMilli();
        System.out.println(maxKCornerElements.maxKCornerGFG(new int[]{100, 200, 1, 2, 3, 4, 5, 101}, k));
        System.out.println(maxKCornerElements.maxKCornerGFG(new int[]{1, 2, 105, 4, 5, 6, 7}, k));
        System.out.println(maxKCornerElements.maxKCorner(new int[]{100, 200, 105, 4000, 500, 60, 7}, k));
        System.out.println(maxKCornerElements.maxKCornerGFG(new int[]{-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35}, 48));
        System.out.println("Time taken:" + (Instant.now().toEpochMilli() - startTime));
    }
}

