package com.practice.interviewBit;

/**
 * Given an integer array A of size N. You need to count the number of special elements in the given array.
 *
 * A element is special if removal of that element make the array balanced.
 *
 * Array will be balanced if sum of even index element equal to sum of odd index element.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * First and only argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return an integer denoting the count of special elements.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 1, 6, 4]
 * Input 2:
 *
 *  A = [5, 5, 2, 5, 8]
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  After deleting 1 from array : {2,6,4}
 *     (2+4) = (6)
 *  Hence 1 is the only special element, so count is 1
 * Explanation 2:
 *
 *  If we delete A[0] or A[1] , array will be balanced
 *     (5+5) = (2+8)
 *  So A[0] and A[1] are special elements, so count is 2.
 */
public class BalanceArrayByRemovingEles {
    public int findEleToBalanceTheArray(int[] A){
        int res = 0;
        int len = A.length;
        for(int i=0;i<len;i++){
            int evenPrefix = 0, oddPrefix = 0, evenSuffix = 0, oddSuffix = 0;
            for(int k=0;k<i;k++){
                if(k%2==0) {
                    evenPrefix += A[k];
                }else{
                    oddPrefix += A[k];
                }
            }
            for(int k=i+1;k<len;k++){
                if (k % 2 == 0) {
                    oddSuffix += A[k];
                } else {
                    evenSuffix += A[k];
                }
            }
            if(evenPrefix+evenSuffix == oddPrefix+oddSuffix){
                res++;
                System.out.println("Element to be removed is : "+A[i]+ " at index: "+i);
            }
        }
        return res;
    }

    /**
     * FASTEST
     * @param A
     * @return
     */
    public int findEleToBalanceTheArray2(int[] A) {
        int res = 0;
        int len = A.length;
        int evenPrefix = 0, oddPrefix = 0, evenSuffix = 0, oddSuffix = 0;
        // Loop array and add all the even and odd elements separately. Think that there doesn't exist an element i,
        // if that is the case, even indexes becomes odd and odd becomes even.
        // For ex, in array [4,5,2,7] - Assume ith index doesn't exist (Assume 0th index). In that case array becomes
        // [5,2,7]. Earlier the index of 5 was 1 now it became Zero. Hence, add even indices to OddSuffix and vice-versa.
        for (int i = 0; i < len; i++) {
            if(i%2==0){
                oddSuffix += A[i];
            }else{
                evenSuffix += A[i];
            }
        }
//        Again iterate from beginning,now the even indexes be even and odd be odd until i.
//        ith index is even, remove the element from oddSuffix and vice-versa based on above logic.
//        Add previous elements till i-1 to odd or even based on ith index. We skip ith, so we'll consider up to i-1th only.
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                oddSuffix -= A[i];
                if(i!=0) {
                    oddPrefix += A[i-1];
                }
            }
            else{
                evenSuffix -= A[i];
                evenPrefix += A[i-1];
            }
            if (evenPrefix + evenSuffix == oddPrefix + oddSuffix) {
                res++;
                System.out.println("Element to be removed is : " + A[i] + " at index: " + i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BalanceArrayByRemovingEles b = new BalanceArrayByRemovingEles();
        System.out.println(b.findEleToBalanceTheArray2(new int[]{2, 1, 6, 4}));
        System.out.println(b.findEleToBalanceTheArray2(new int[]{5, 5, 2, 5, 8}));
    }
}
