package com.practice.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubSequence {
    public int lengthOfLIS(int[] nums) {
        int result = 0;
        List<List> finalList = new ArrayList<List>();
        for (int i:nums){
            addLists(finalList, i);
        }
        for (List ll:finalList){
            if (ll.size() > result){
                result = ll.size();
            }
        }
        return  result;
    }

    public List<List> addLists(List<List> fList, int num){
        if (fList.isEmpty()){
            fList.add(List.of(num));
        }
        for (List ll:fList) {
            int index = fList.indexOf(ll);
            ll.add(num);
            if (isIncreasingSeq(ll)){
                fList.set(index, ll);
            }
        }
        return fList;
    }

    private boolean isIncreasingSeq(List<Integer> nums){
        int first = nums.get(0);
        for (int j=1;j<nums.size();j++){
            if (first > nums.get(j)){
                return false;
            }
            first = nums.get(j);
        }
        return true;
    }

    public static void main(String[] args) {
        LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
        System.out.println(lis.lengthOfLIS(new int[]{0,3,1,6,2,2,7}));
    }

}
