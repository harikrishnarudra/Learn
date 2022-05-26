package com.practice.interviewBit;

public class MaximumConsecutiveGap {

    public int maximumGap(final int[] A) {
        int len = A.length;
        int md = 0;
        if(len <= 1){
            return md;
        }
        if (len == 2) {
            md =  Math.abs(A[0]-A[1]);
        }
        if(len > 2){
            int min = A[0], max=A[0], diff = 0;
            boolean lastMidStep = false;
            for(int i=1;i<len;i++){
                if(A[i] < min){
                    if(lastMidStep) md = 0;
                    max = min;
                    min = A[i];
                    diff = max - min;
                    if(diff > md) {
                        md = diff;
                    }
                }
                if(A[i] > max){
                    if (lastMidStep) md = 0;
                    min = max;
                    max = A[i];
                    diff = max - min;
                    if(diff > md){
                        md = diff;
                    }
                }
                if(A[i] > min && A[i] < max){
                    int fd = A[i] - min;
                    int sd = max - A[i];
                    if(fd > sd){
                        md = fd;
                    }
                    else{
                        md = sd;
                    }
                    max = A[i];
                    lastMidStep=true;
                }
            }
        }
        return md;
    }

    public static void main(String[] args) {
        MaximumConsecutiveGap m = new MaximumConsecutiveGap();
        System.out.println(m.maximumGap(new int[]{1, 10, 5}));
        System.out.println(m.maximumGap(new int[]{2, 1, 6, 4}));
        System.out.println(m.maximumGap(new int[]{2, 9, 8, 1}));
        System.out.println(m.maximumGap(new int[]{21, 1, 45, 10, 33}));
    }
}
