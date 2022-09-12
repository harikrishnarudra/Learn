package com.practice.learn;

import java.util.Arrays;

public class MoveElementsInAnArray {

    public int[] moveElements(int[] arr){
        if(arr==null) return arr;
        int prevEle = arr[0];
        int prevInd = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i] != -1){
                if(arr[i] == prevEle){
                    arr[i] += prevEle;
                    arr[prevInd] = -1;
                }
                prevEle = arr[i];
                prevInd = i;
            }else{
                int k=i;
                int j = i - 1;
                while(j>=0){
                    int temp = arr[k];
                    arr[k] = arr[j];
                    arr[j] = temp;
                    if (prevInd == j) {
                        prevInd = k;
                    }
                    k--;
                    j--;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        MoveElementsInAnArray m = new MoveElementsInAnArray();
        int[] ar = new int[]{-1,2,-1,-1};
        int[] arr = m.moveElements(ar);
        Arrays.stream(arr).sequential().forEach(System.out::println);
        System.out.println("===========");
        ar = new int[]{2, 4, -1, -1};
        arr = m.moveElements(ar);
        Arrays.stream(arr).sequential().forEach(System.out::println);
        System.out.println("===========");
        ar = new int[]{2, -1, 2, -1};
        arr = m.moveElements(ar);
        Arrays.stream(arr).sequential().forEach(System.out::println);
        System.out.println("===========");
        ar = new int[]{2, 2, -1, -1};
        arr = m.moveElements(ar);
        Arrays.stream(arr).sequential().forEach(System.out::println);
        System.out.println("===========");
        ar = new int[]{2, 4, 8, 16};
        arr = m.moveElements(ar);
        Arrays.stream(arr).sequential().forEach(System.out::println);
        System.out.println("===========");
        ar = new int[]{2, 2, 2, 2};
        arr = m.moveElements(ar);
        Arrays.stream(arr).sequential().forEach(System.out::println);
        System.out.println("===========");
        ar = new int[]{2, 2, 2, -1};
        arr = m.moveElements(ar);
        Arrays.stream(arr).sequential().forEach(System.out::println);

    }
}
