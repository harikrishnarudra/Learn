package com.practice.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountDistinct {
    public int countDistinct(int[] nums, int k, int p) {
        List<Integer> indexList = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<nums.length; i++){
            if(nums[i]%p==0){
                indexList.add(i);
            }
        }

        Set<String> set = new HashSet<>();
        int count = 0;
        for(int i=0;i<n;i++){
            String prev = nums[i] + "";
            set.add(prev);
            if(indexList.contains(i)){
                count++;
            }
            for(int j=i+1;j<n;j++){
                if(count<k){
                    prev = prev+"-"+nums[j];
                    set.add(prev);
                    if(indexList.contains(j)){
                        count++;
                    }
                }else{
                    break;
                }
            }
            count=0;
        }
        System.out.println(set);
        return set.size();
    }

    public static void main(String[] args) {
        CountDistinct c = new CountDistinct();
        /*System.out.println(c.countDistinct(new int[]{2, 3, 3, 2, 2}, 2, 2));
        System.out.println(c.countDistinct(new int[]{2, 3, 3, 2, 2}, 5, 1));
        System.out.println(c.countDistinct(new int[]{1, 2, 3, 4}, 4, 1));
        System.out.println(c.countDistinct(new int[]{1, 2, 3, 4, 5}, 5, 1));*/
        System.out.println(c.countDistinct(new int[]{1, 9,8,7,19}, 1, 6));
        System.out.println(c.countDistinct(new int[]{10, 2, 17, 7, 20}, 1, 10));
    }
}
