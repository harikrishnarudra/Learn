package com.test.learn;

import java.util.ArrayList;
import java.util.List;

public class findOddInRange {

    static List<Integer> oddNumbers(int l, int r) {
        List<Integer> outList = new ArrayList<>();
        if (l%2==0){
            l = l+1;
        }
        for (int i=l; i<r;i=i+2){
            outList.add(i);
        }
        if (r%2!=0){
            outList.add(r);
        }
        return outList;
    }
    public  static void main(String[] args){
        List<Integer> output = findOddInRange.oddNumbers(Integer.parseInt("13456725687549"), Integer.parseInt("13456725687559"));
        for (Integer a:output) {
            System.out.println(a);
        }
    }
}