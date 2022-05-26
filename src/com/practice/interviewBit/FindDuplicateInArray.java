package com.practice.interviewBit;

/**
 * Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.
 * Sample Input:
 * [3 4 1 4 1]
 * Sample Output:
 * 1
 * If there are multiple possible answers ( like in the sample case above ), output any one.
 * If there is no duplicate, output -1
 */
public class FindDuplicateInArray {

    public int repeatedNumber(final int[] A) {
        if(A==null || A.length<=1){
            return -1;
        }
        int[] res = new int[A.length+1];
        for(int i:A){
            if(res[i]==1){
                return i;
            }else{
                res[i] = 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindDuplicateInArray f = new FindDuplicateInArray();
        System.out.println(f.repeatedNumber(new int[]{3,4,1,2,1}));
        System.out.println(f.repeatedNumber(new int[]{3, 4, 1, 4, 1}));
        System.out.println(f.repeatedNumber(new int[]{3}));
        System.out.println(f.repeatedNumber(new int[]{}));
    }
}
