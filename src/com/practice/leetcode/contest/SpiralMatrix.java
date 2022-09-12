package com.practice.leetcode.contest;

import com.practice.model.ListNode;

public class SpiralMatrix {
    //Not working
    public int[][] spiralMatrix2(int n, int m, ListNode head) {
        int[][] a = new int[n][m];
        int k = 0, p = 0;
        int i = 0, j = 0;
        int q = m / 2, r = n+1 / 2;
        while (m > q || n > r) {
            while (j < m) {
                a[i][j++] = getElement(head);
                if(head.next!=null) {
                    head = head.next;
                }else{
                    head = null;
                }
            }
            i++;
            j--;
            while (i < n) {
                a[i++][j] = getElement(head);
                if (head.next != null) {
                    head = head.next;
                } else {
                    head = null;
                }
            }
            i--;
            j--;
            while (j >= p) {
                a[i][j--] = getElement(head);
                if (head.next != null) {
                    head = head.next;
                } else {
                    head = null;
                }
            }
            p++;
            j++;
            k++;
            while (i > k) {
                a[--i][j] = getElement(head);
                if (head.next != null) {
                    head = head.next;
                } else {
                    head = null;
                }
            }
            j++;
            m--;
            n--;
        }
        return a;
    }

    private int getElement(ListNode head){
        if(head!=null){
            return head.val;
        }
        return -1;
    }
//Working Code
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = -1;
            }
        }
        for (int i = 0, j, k; i < (m + 1) / 2; i++) {
            for (j = i, k = i; k < n - i && head != null; k++, head = head.next) {
                result[j][k] = head.val;
            }
            for (j++, k--; j < m - i && head != null; j++, head = head.next) {
                result[j][k] = head.val;
            }
            for (j--, k--; k >= i && head != null; k--, head = head.next) {
                result[j][k] = head.val;
            }
            for (j--, k++; j > i && head != null; j--, head = head.next) {
                result[j][k] = head.val;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        int[][] ints = s.spiralMatrix(3, 5, null);
        for(int i=0;i<3;i++){
            for(int j=0;j<5;j++){
                System.out.println(ints[i][j]);
            }
        }
    }
}
