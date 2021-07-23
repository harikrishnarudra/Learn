package Interviews.amz.demo;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.ArrayList;
import java.util.List;

// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days) {
        // WRITE YOUR CODE HERE
        /*Arrays.stream(states)
              .collect(Collectors.toList());
              Collections.addAll(integerStates, states);*/

        ArrayList<Integer> integerStates = new ArrayList<Integer>();
        ArrayList<Integer> resultStates = null;
        for (int i : states) {
            integerStates.add(i);
        }
        if (days == 0) {
            return integerStates;
        }
        while (days > 0) {
            resultStates = new ArrayList<Integer>();
            for (int j = 0; j < 8; j++) {
                Integer prevValue = 0;
                Integer nextValue = 0;
                int k = j-1;
                int p = j+1;
                if (k >= 0) {
                    prevValue = integerStates.indexOf(k);
                }
                if (p < 8) {
                    nextValue = integerStates.indexOf(p);
                }
                if (prevValue == nextValue)
                    resultStates.add(0);
                else
                    resultStates.add(1);
            }
            days = days - 1;
            integerStates = resultStates;
        }
        return resultStates;
    }
    // METHOD SIGNATURE ENDS
    public static void main(String[] args){
        Solution s = new Solution();
        /*int[] states = new int[]{1,1,1,0,1,1,1,1};
        System.out.println(s.cellCompete(states,2));*/

        int[] states2 = new int[]{1, 0, 0, 0, 0, 1, 0, 0};
        System.out.println(s.cellCompete(states2, 1));

    }
}
