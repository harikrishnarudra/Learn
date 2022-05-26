package com.practice.interviewBit;

/**
 * There is a corridor in a Jail which is N units long. Given an array A of size N. The ith index of this array is 0 if the light at ith position is faulty otherwise it is 1.
 * All the lights are of specific power B which if is placed at position X, it can light the corridor from [ X-B+1, X+B-1].
 * Initially all lights are off.
 * Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.
 *
 * Problem Constraints
 * 1 <= N <= 1000
 *
 * 1 <= B <= 1000
 *
 * Input Format
 * First argument is an integer array A where A[i] is either 0 or 1.
 *
 * Second argument is an integer B.
 *
 * Output Format
 * Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.
 *
 * Example Input
 * Input 1:
 *
 * A = [ 0, 0, 1, 1, 1, 0, 0, 1].
 * B = 3
 * Input 2:
 *
 * A = [ 0, 0, 0, 1, 0].
 * B = 3
 *
 * Example Output
 * Output 1:
 *
 * 2
 * Output 2:
 *
 * -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * In the first configuration, Turn on the lights at 3rd and 8th index.
 * Light at 3rd index covers from [ 1, 5] and light at 8th index covers [ 6, 8].
 * Explanation 2:
 *
 * In the second configuration, there is no light which can light the first corridor.
 */
public class MinLightsToActivate {

    public static int findMinLightsToActivate(int[] A, int B){
        if (A.length < B) {
            // if there are less number of elements in A than B, then lighting any one of the lights will give us an answer.
            if (A[1] != -1) return 1;
            else return -1;
        }
        // minDone and maxDone will store the values of the light that was switched on before and the last index where we can see the effect respectively
        int minDone = 0;
        int maxDone = 0;
        // this will traverse and handle the indexes in the array
        int curLight = B - 1;
        // this will be our final answer
        int count = 0;
        // while the last light has not been switched on
        while (maxDone < A.length - 1) {
            // initially, our curLight is set to the most rightmost possible light that can light up all possible indexes before it. Hence, we come back to ensure we get the rightmost functional light.
            while (A[curLight] == 0) {
                // if we reach the first light, or the light which was switched on earlier without encountering even a single 1, then it is impossible to light the particular indexes
                if (curLight == 0 || curLight == minDone + 1) return -1;
                curLight--;
            }
            // one more light to be turned on
            count++;
            // we set the last light switched on to curLight
            minDone = curLight;
            // this is the index of the last index that could be affected due to the light swithed on
            maxDone = curLight + B - 1;
            // we set curLight to maxDone+B, to ensure if we turn it on, all lights in between can be switched on too.
            curLight = Math.min(A.length - 1, maxDone + B);
        }
        // we return the count;
        return count;
    }

    public static void main(String[] args) {
        MinLightsToActivate m = new MinLightsToActivate();
        int[] a = new int[]{0, 0, 1, 1, 1, 0, 0, 1};
        int b=3;
        System.out.println(findMinLightsToActivate(a, b));
        a = new int[]{0, 0, 1, 0, 0, 0, 0, 1};
        b = 3;
        System.out.println(findMinLightsToActivate(a, b));
        a = new int[]{0, 0, 0, 1, 0};
        b = 3;
        System.out.println(findMinLightsToActivate(a, b));
    }
}
