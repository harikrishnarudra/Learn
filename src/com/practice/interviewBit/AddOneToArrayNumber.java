package com.practice.interviewBit;

import java.util.Arrays;

/**
 * Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example:
 * for this problem, following are some good questions to ask :
 *
 * Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
 * A : For the purpose of this question, YES
 * Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
 * A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 *
 *
 * Input Format
 * First argument is an array of digits.
 *
 *
 *
 * Output Format
 * Return the array of digits after adding one.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * [1, 2, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 * [1, 2, 4]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Given vector is [1, 2, 3].
 * The returned vector should be [1, 2, 4] as 123 + 1 = 124.
 */
public class AddOneToArrayNumber {
    public int[] plusOne(int[] nums) {
        if(nums==null || nums.length==0){
            return nums;
        }
        int size = nums.length-1;
        int res = nums[size]+1;
        if(res>=10){
            int cf = res/10;
            res = res%10;
            nums[size] = res;
            int index = size-1;
            while(cf > 0){
                if(index==-1){
                    // Create a new array
                    int[] newA = new int[size+2];
                    newA[0] = cf;
                    int j=1;
                    for(int i=0;i< nums.length; i++){
                        newA[j++] = nums[i];
                    }
                    return newA;
                }
                res = nums[index] + cf;
                cf = res/10;
                res = res%10;
                nums[index] = res;
                index--;
            }
        }
        else{
            nums[size] = res;
        }
        int k = 0;
        if(nums[k] == 0){
            int count = 0;
            while(nums[k++]==0){
                count ++;
            }
            int[] newB = new int[nums.length-count];
            int j = 0;
            for (int i = k-1; i < nums.length; i++) {
                newB[j++] = nums[i];
            }
            return newB;
        }
        return nums;
    }

    public static void main(String[] args) {
        AddOneToArrayNumber a = new AddOneToArrayNumber();
        int[] res = a.plusOne(new int[]{1, 2, 3});
        Arrays.stream(res).forEach(System.out::println);
        System.out.println(" ----- ");
        res = a.plusOne(new int[]{0,1, 2, 3});
        Arrays.stream(res).forEach(System.out::println);
        System.out.println(" ----- ");
        res = a.plusOne(new int[]{9,9,9});
        Arrays.stream(res).forEach(System.out::println);
        System.out.println(" ----- ");
        res = a.plusOne(new int[]{0, 0});
        Arrays.stream(res).forEach(System.out::println);
        System.out.println(" ----- ");
        res = a.plusOne(new int[]{0, 0, 4, 4, 6, 0, 9, 6, 5, 1});
        Arrays.stream(res).forEach(System.out::println);
    }
}
