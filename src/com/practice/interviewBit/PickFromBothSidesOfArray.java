package com.practice.interviewBit;

/**
 * Given an integer array A of size N.
 *
 * You can pick B elements from either left or right end of the array A to get maximum sum.
 *
 * Find and return this maximum possible sum.
 *
 * NOTE: Suppose B = 4 and array A contains 10 elements then
 *
 * You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc . you need to return the maximum possible sum of elements you can pick.
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= B <= N
 *
 * -103 <= A[i] <= 103
 *
 * Input Format
 * First argument is an integer array A.
 *
 * Second argument is an integer B.
 *
 * Output Format
 * Return an integer denoting the maximum possible sum of elements you picked.
 *
 * Example Input
 * Input 1:
 *
 *  A = [5, -2, 3 , 1, 2]
 *  B = 3
 * Input 2:
 *
 *  A = [1, 2]
 *  B = 1
 *
 * Example Output
 * Output 1:
 *  8
 * Output 2:
 *  2
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
 * Explanation 2:
 *
 *  Pick element 2 from end as this is the maximum we can get
 */
public class PickFromBothSidesOfArray {
    public int solve(int[] nums, int k) {
        int maxSum;
        int currSum = 0;
        for(int i=0;i<k;i++){
            currSum += nums[i];
        }
        maxSum = currSum;
        int leng = nums.length-1;
        for(int j=k-1; j>=0; j--){
            currSum = currSum-nums[j]+nums[leng--];
            if(currSum > maxSum){
                maxSum = currSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        PickFromBothSidesOfArray p = new PickFromBothSidesOfArray();
        System.out.println(p.solve(new int[]{5, -2, 3, 1, 2}, 3));
        System.out.println(p.solve(new int[]{1, 2}, 1));
        System.out.println(p.solve(new int[]{-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35}, 48));
    }
}
