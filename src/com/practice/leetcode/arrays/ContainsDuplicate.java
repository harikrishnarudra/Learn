package com.practice.leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 * There is a lot of difference between Set<Integer> unique = new HashSet<>(); and
 * Set<Integer> unique = new HashSet<>(nums.length); - This is 3 times faster than above.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>(nums.length);
        for (int i:nums) {
            if(unique.contains(i)){
                return true;
            }
            unique.add(i);
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        return nums.length!=Arrays.stream(nums).distinct().count();
    }

    public boolean containsDuplicate3(int[] nums) {
        byte[] mark = new byte[150000];
        for (int i : nums) {
            System.out.println("i=" + i);
            int j = i / 8;
            System.out.println("j="+j);
            int k = i % 8;
            System.out.println("k=" + k);
            int check = 1 << k;
            System.out.println("check=" + check);
            System.out.println("mark[j]=" + mark[j]);
            int m = mark[j] & check;
            System.out.println("mark[j] & check=" +m);
            if (m != 0) {
                return true;
            }
            mark[j] |= check;
            System.out.println("mark[j] | check=" + mark[j]);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate c = new ContainsDuplicate();
        int[] num = new int[]{1,2,3,4,1};
        System.out.println(c.containsDuplicate3(num));
    }
}
