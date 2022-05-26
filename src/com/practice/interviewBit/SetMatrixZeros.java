package com.practice.interviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetMatrixZeros {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int rows = a.size();
        int cols = a.get(0).size();
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(a.get(i).get(j)==0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    a.get(i).remove(j);
                    a.get(i).add(j,0);
                }
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeros s = new SetMatrixZeros();
        ArrayList<Integer> ll = new ArrayList<>();
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        ll.add(1);
        ll.add(0);
        ll.add(1);
        l.add(ll);

        ll = new ArrayList<>();
        ll.add(1);
        ll.add(1);
        ll.add(1);
        l.add(ll);

        ll = new ArrayList<>();
        ll.add(1);
        ll.add(0);
        ll.add(1);
        l.add(ll);

        s.setZeroes(l);
        for(int i=0;i<l.size();i++){
            for(int j=0;j<ll.size();j++){
                System.out.println(l.get(i).get(j));
            }
        }
    }
}
