package com.practice.interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraySum {
    public ArrayList<Integer> addArrays(ArrayList<Integer> A, ArrayList<Integer> B) {
        int i=A.size()-1, j = B.size()-1;
        int maxSize = i;
        if(j>maxSize){
            maxSize = j;
        }
        ArrayList<Integer> resList = new ArrayList(maxSize+1);
        int cf = 0, res=0;
        while(i>=0 && j>=0){
            res = cf + A.get(i) + B.get(j);
            cf = res / 10;
            res = res % 10;
            resList.add(0, res);
            i--;
            j--;
        }
        while(i>=0){
            res = cf + A.get(i);
            cf = res / 10;
            res = res % 10;
            resList.add(0, res);
            i--;
        }
        while (j >= 0) {
            res = cf + B.get(j);
            cf = res / 10;
            res = res % 10;
            resList.add(0, res);
            j--;
        }
        if(cf!=0){
            resList.add(0, cf);
        }
        return resList;
    }


    public ArrayList<Integer> addArrays_Notworking(ArrayList<Integer> A, ArrayList<Integer> B) {
        StringBuilder strA = new StringBuilder();
        for (int i = 0; i < A.size(); i++) {
            strA.append(A.get(i));
        }
        StringBuilder strB = new StringBuilder();
        for (int i = 0; i < B.size(); i++) {
            strB.append(B.get(i));
        }
        long res = Long.parseLong(strA.toString()) + Long.parseLong(strB.toString());
        int maxSize = A.size();
        if (A.size() < B.size()) {
            maxSize = B.size();
        }
        ArrayList<Integer> resArr = new ArrayList<>(maxSize);
        while (res < 10 && maxSize >= 0) {
            int ele = (int) (res % 10);
            res = res / 10;
            resArr.add(maxSize - 1, ele);
        }
        resArr.add(0, (int) res);
        return resArr;
    }

    public static void main(String[] args) {
        ArraySum arraySum = new ArraySum();
        int[] a = new int[]{4, 3, 6, 7, 9, 9, 1, 7, 8 };
        int[] b = new int[]{7, 5, 8, 9};
        ArrayList<Integer> aList = (ArrayList<Integer>) Arrays.stream(a).boxed().collect(Collectors.toList());
        ArrayList<Integer> bList = (ArrayList<Integer>) Arrays.stream(b).boxed().collect(Collectors.toList());
        ArrayList<Integer> res = arraySum.addArrays(aList, bList);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}
