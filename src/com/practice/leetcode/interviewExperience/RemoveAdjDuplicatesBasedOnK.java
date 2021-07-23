package com.practice.leetcode.interviewExperience;

public class RemoveAdjDuplicatesBasedOnK {

    //Using 2 pointers
    //one is to check for the previous element and other is to move forward
    //count of each adjacent character is maintained in a separate array

    public String removeDuplicates(String s, int k) {
        int i=0, n=s.length(), count[] = new int[n];
        char[] chars = s.toCharArray();
        for(int j=0;j<n;++i,++j){
            chars[i]=chars[j];
            count[i] = i>0 && chars[i-1]==chars[j] ? count[i-1]+1 : 1;
            if(count[i]==k){
                i -=k;
            }
        }
        return String.valueOf(chars, 0, i);
    }

    public static void main(String[] args) {
        RemoveAdjDuplicatesBasedOnK removeAdjDuplicatesBasedOnK = new RemoveAdjDuplicatesBasedOnK();
        System.out.println(removeAdjDuplicatesBasedOnK.removeDuplicates("deeedbbcccbdaa", 3));
    }
}
