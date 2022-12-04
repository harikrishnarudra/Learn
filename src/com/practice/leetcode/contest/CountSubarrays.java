package com.practice.leetcode.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountSubarrays {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        Set<List<Integer>> resultSet = new HashSet<>();
        int length = nums.length;
        int minPtr = -1, maxPtr = -1;
        for(int i=0;i<length; i++){
            if(nums[i] == minK){
                minPtr = i;
            }
            if(nums[i] == maxK){
                maxPtr = i;
            }
            if ((minPtr != -1 && maxPtr == -1) || (minPtr == -1 && maxPtr != -1)) {
                if(nums[i] <= minK && nums[i] >= maxK){
                    minPtr = -1;
                    maxPtr = -1;
                }
            }
            if(minPtr!=-1 && maxPtr!=-1){
                Set<List<Integer>> subset = new HashSet<>();
                //Find out if there is any element which is larger than maxEle and less than minEle within the ptrs.
                //If found make these ptrs as -1 and move ahead.
                //Else move forward in the array and add it to set of indexes.
                //Move backward also in the array.
                int low = minPtr, high = maxPtr;
                if(low > high) {
                    low = maxPtr;
                    high = minPtr;
                }
                if(violatingArray(low, high, minK, maxK, nums)){
                    minPtr = -1;
                    maxPtr = -1;
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(low);
                    list.add(high);
                    subset.add(list);
                    int lowPtr = low-1, highPtr = high+1;
                    while(lowPtr > 0 && lowPtr < low){
                        if(nums[lowPtr] >=minK && nums[lowPtr] <=maxK){
                            list = new ArrayList<>();
                            list.add(low);
                            list.add(high);
                            list.add(lowPtr);
                            subset.add(list);
                        }else{
                            break;
                        }
                        lowPtr--;
                    }
                    while (highPtr < length && highPtr > high) {
                        if (nums[highPtr] >= minK && nums[highPtr] <= maxK) {
                            list = new ArrayList<>();
                            list.add(low);
                            list.add(high);
                            list.add(highPtr);
                            subset.add(list);
                        }else{
                            break;
                        }
                        highPtr++;
                    }
                    resultSet.addAll(subset);
                }

            }
        }
        return resultSet.size();

    }

    private boolean violatingArray(int low, int high, int mLow, int mHigh, int[] nums){
        for(int i=low;i<high;i++){
            if(nums[i] < mLow || nums[i] > mHigh){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CountSubarrays c = new CountSubarrays();
//        System.out.println(c.countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5));
        System.out.println(c.countSubarrays(new int[]{1,1,1}, 1, 1));
    }
}
