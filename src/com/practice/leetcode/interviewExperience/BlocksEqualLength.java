package com.practice.leetcode.interviewExperience;

import java.util.ArrayList;
import java.util.List;

/**
 * Codility
 */
public class BlocksEqualLength {
    public int charsNeededToMakeEqualBlocks(String s){
        char[] chars = s.toCharArray();
        int maxBlockLength = 0;
        int startInd = 0;
        int numOfCharsNeeded = 0;
        List<Integer> blocksLengths = new ArrayList<>();
        int i=1;
        for(;i<chars.length;i++){
            if(chars[i-1]!=chars[i]){
                if((i-startInd) > maxBlockLength){
                    maxBlockLength = i - startInd;
                }
                blocksLengths.add(i - startInd);
                startInd=i;
            }
        }
        if ((i - startInd) > maxBlockLength) {
            maxBlockLength = i - startInd;
        }
        blocksLengths.add(i - startInd);
        for(int j=0;j<blocksLengths.size();j++){
            numOfCharsNeeded += maxBlockLength-blocksLengths.get(j);
        }
        return numOfCharsNeeded;
    }

    public int charsNeededToMakeEqualBlocksWithoutExtraSpace(String s) {
        char[] chars = s.toCharArray();
        int maxBlockLength = 0;
        int startInd = 0;
        int numberOfBlocks = 0;
        int i = 1;
        for (; i < chars.length; i++) {
            if (chars[i - 1] != chars[i]) {
                maxBlockLength = Math.max(maxBlockLength, i - startInd);
                /*if ((i - startInd) > maxBlockLength) {
                    maxBlockLength = i - startInd;
                }*/
                numberOfBlocks++;
                startInd = i;
            }
        }
        /*if ((i - startInd) > maxBlockLength) {
            maxBlockLength = i - startInd;
        }*/
        maxBlockLength = Math.max(maxBlockLength, i - startInd);
        numberOfBlocks++;
        return maxBlockLength*numberOfBlocks - chars.length;
    }

    public static void main(String[] args) {
        BlocksEqualLength b = new BlocksEqualLength();
        System.out.println(b.charsNeededToMakeEqualBlocks("babaa"));
        System.out.println(b.charsNeededToMakeEqualBlocks("aaaa"));
        System.out.println(b.charsNeededToMakeEqualBlocks("bbbab"));
        System.out.println(b.charsNeededToMakeEqualBlocks("bbbaaabbb"));
        System.out.println("===============");
        System.out.println(b.charsNeededToMakeEqualBlocksWithoutExtraSpace("babaa"));
        System.out.println(b.charsNeededToMakeEqualBlocksWithoutExtraSpace("aaaa"));
        System.out.println(b.charsNeededToMakeEqualBlocksWithoutExtraSpace("bbbab"));
        System.out.println(b.charsNeededToMakeEqualBlocksWithoutExtraSpace("bbbaaabbb"));
    }
}
