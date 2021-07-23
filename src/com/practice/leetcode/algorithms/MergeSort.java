package com.practice.leetcode.algorithms;

public class MergeSort {

    public static void mergeSort(int[] arr, int start, int end){
        if(end > start){
            int mid = (end+start)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }

    }

    public static void merge(int[] arr, int start, int mid,int end){
        int temp[] = new int[end-start+1];

        int i=start, j=mid+1, k=0;
        while (i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                temp[k]=arr[i];
                k++;
                i++;
            }
            else{
                temp[k]=arr[j];
                k++;
                j++;
            }
        }
        while(i<=mid){
            temp[k]=arr[i];
            k++;
            i++;
        }
        while (j <= end) {
            temp[k] = arr[j];
            k++;
            j++;
        }
        for(i=start;i<=end;i++){
            arr[i]= temp[i-start];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,3,4,6,1,7,8};
        MergeSort.mergeSort(arr, 0, 6);
        for(int i=0;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
