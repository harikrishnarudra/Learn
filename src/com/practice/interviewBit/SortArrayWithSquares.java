package com.practice.interviewBit;

import java.util.Arrays;

public class SortArrayWithSquares {

    /**
     * Proper solution
     * @param A
     * @return
     */
    public int[] solve(int[] A) {
        int ans[] = new int[A.length];
        int i = 0, j = A.length - 1, index = A.length - 1;

        while (i <= j) {
            if (i == j) {
                ans[index--] = A[i] * A[i];
                break;
            }
            int val1 = Math.abs(A[i]);
            int val2 = Math.abs(A[j]);

            if (val1 > val2) {
                ans[index--] = val1 * val1;
                i++;
            } else {
                ans[index--] = val2 * val2;
                j--;
            }
        }
        return ans;
    }

    public void doMergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            doMergeSort(arr, start, mid);
            doMergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] > arr[j]) {
                temp[k++] = arr[j++];
            } else {
                temp[k++] = arr[i++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        for (i = start; i <= end; i++) {
            arr[i] = temp[i - start];
        }
    }

    public static void main(String[] args) {
        SortArrayWithSquares s = new SortArrayWithSquares();
//        int[] arr = new int[]{-6, -3, -1, 2, 4, 5};
        int[] arr = new int[]{6, 3, 1, 2, 4, 5};
        for(int i=0;i<arr.length;i++){
            arr[i] *=arr[i];
        }
        s.doMergeSort(arr, 0, 5);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
