package com.practice.interviewBit;

import java.util.Arrays;

public class MergeSort {
    public void doMergeSort(int[] arr, int start, int end){
        if(start<end){
            int mid = (start+end)/2;
            doMergeSort(arr, start,mid);
            doMergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    public void merge(int[] arr, int start, int mid, int end){
        int[] temp = new int[end-start+1];
        int i=start, j=mid+1, k=0;
        while (i<=mid && j <= end){
            if(arr[i]>arr[j]){
                temp[k++] = arr[j++];
            }else{
                temp[k++] = arr[i++];
            }
        }
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        for( i=start;i<=end;i++){
            arr[i] = temp[i-start];
        }
    }

    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        int[] arr = new int[]{1, 10, 5};
        m.doMergeSort(arr, 0, 2);
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("=======");
        arr = new int[]{2, 1, 6, 4};
        m.doMergeSort(arr, 0, 3);
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("=======");
        arr = new int[]{2, 9, 8, 1};
        m.doMergeSort(arr, 0, 3);
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("=======");
        arr = new int[]{21, 1, 45, 10, 33};
        m.doMergeSort(arr, 0, 4);
        Arrays.stream(arr).forEach(System.out::println);
    }

}
