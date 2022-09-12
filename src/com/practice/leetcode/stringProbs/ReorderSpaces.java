package com.practice.leetcode.stringProbs;

import java.util.ArrayList;
import java.util.List;

public class ReorderSpaces {
    public String reorderSpaces(String text) {
        int spaceCount = 0, i = -1, j = -1;
        List<String> words = new ArrayList();
        char[] arr = text.toCharArray();
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] == ' ') {
                if (i != -1 && j != -1) {
                    String word = text.substring(i, j + 1);
                    words.add(word);
                    i = -1;
                    j = -1;
                    spaceCount++;
                } else {
                    spaceCount++;
                }
            } else {
                if (i != -1) {
                    j++;
                } else {
                    i = k;
                    j = k;
                }
            }
        }
        if (i != -1 && j != -1) {
            String word = text.substring(i, j + 1);
            words.add(word);
        }
        int equalSpaces =0, finalSpaces= spaceCount;
        System.out.println("Words: " + words);
        System.out.println("totalSpaces: "+ spaceCount);
        if(words.size()>1) {
            equalSpaces = spaceCount / (words.size() - 1);
            System.out.println("EqSpaces: " + equalSpaces);
        }
        if (words.size() > 1) {
            finalSpaces = spaceCount % (words.size() - 1);
            System.out.println("FinalSpaces: " + finalSpaces);
        }
        StringBuffer strb = new StringBuffer();
        for (int w=0;w<words.size();w++) {
            strb.append(words.get(w));
            if(w< words.size()-1){
                for (int p = 0; p < equalSpaces; p++) {
                    strb.append(' ');
                }
            }
        }
        for (int p = 0; p < finalSpaces; p++) {
            strb.append(' ');
        }
        return strb.toString();
    }

    public static void main(String[] args) {
        ReorderSpaces r = new ReorderSpaces();
        System.out.println(r.reorderSpaces(" practice   makes   perfect"));
        System.out.println(r.reorderSpaces("a  "));
    }
}
