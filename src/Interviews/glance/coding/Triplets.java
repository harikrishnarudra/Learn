package Interviews.glance.coding;


import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two arrays of integers nums1 and nums2, return the number of triplets formed  under the following rules:
 *
 * Triplet (i, j, k) if nums1[i] ^2 == nums2[j] * nums2[k] where 0 <= i < nums1.length and 0 <= j < k < nums2.length
 *
 * Triplet (i, j, k) if nums2[i] ^2 == nums1[j] * nums1[k] where 0 <= i < nums2.length and 0 <= j < k < nums1.length
 *
 * nput: nums1 = [7,4], nums2 = [5,2,8,9]
 * Output: 1
 * Explanation: Type 1: (1, 1, 2), nums1[1]2 = nums2[1] * nums2[2]. (16 = 2 * 8).
 *
 * Input: nums1 = [1,1], nums2 = [1,1,1]
 * Output: 9
 *
 * Explanation: All Triplets are valid, because 1^2 = 1 * 1.
 * Type 1: (0,0,1), (0,0,2), (0,1,2), (1,0,1), (1,0,2), (1,1,2).  nums1[i]2 = nums2[j] * nums2[k].
 * Type 2: (0,0,1), (1,0,1), (2,0,1). nums2[i]2 = nums1[j] * nums1[k].
 *
 *
 * Input: nums1 = [7,7,8,3], nums2 = [1,2,9,7]
 * Output: 2
 * Explanation: There are 2 valid triplets.
 * Type 1: (3,0,2).  nums1[3]2 = nums2[0] * nums2[2].
 * Type 2: (3,0,1).  nums2[3]2 = nums1[0] * nums1[1]
 */
public class Triplets {

    public int getTriplets(int[] nums1, int[] nums2){
        int result = 0;
        Map<Integer, Integer> nums1Map = this.getProductMap(nums1);
        Map<Integer, Integer> nums2Map = this.getProductMap(nums2);
        for(int i:nums1){
            int prod = i*i;
            if(nums2Map.containsKey(prod)){
                result += nums2Map.get(prod);
            }
        }
        for (int i : nums2) {
            int prod = i * i;
            if (nums1Map.containsKey(prod)) {
                result += nums1Map.get(prod);
            }
        }
        return result;
    }

    private Map<Integer, Integer> getProductMap(int[] nums){
        Map<Integer, Integer> nums1Map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int val = nums[i]*nums[j];
                nums1Map.put(val, nums1Map.getOrDefault(val,0)+1);
            }
        }
        return nums1Map;
    }


    public static void main(String[] args) {

        Triplets solution = new Triplets();
        Assert.assertEquals(1, solution.getTriplets(new int[]{7, 4}, new int[]{5, 2, 8, 9}));
        Assert.assertEquals(9, solution.getTriplets(new int[]{1, 1}, new int[]{1, 1, 1}));
        Assert.assertEquals(2, solution.getTriplets(new int[]{7, 7, 8, 3}, new int[]{1, 2, 9, 7}));
    }
}
