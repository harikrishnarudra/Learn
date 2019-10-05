package com.test.learn;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.List;

public class FindEleInArr {

    static String findNumber(List<Integer> arr, int k){
        for (Integer a:arr) {
            if (k == a.intValue()){
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args){
        FindEleInArr f = new FindEleInArr();
        List<Integer> lisr = new ArrayList<Integer>();
        lisr.add(1);
        lisr.add(2);
        lisr.add(3);
        System.out.println(FindEleInArr.findNumber(lisr, 5));
    }
}
