package com.practice.leetcode.contest;

public class SumOfNumberAndReverse {

    public boolean sumOfNumberAndReverse(int num) {
        if (num == 0) {
            return true;
        }
        int i = 0;
        while (++i < num) {
            int x=i,y=0;
            while(x > 0){
                y = y*10+x%10;
                x /= 10;
            }
            if(i+y == num){
                return true;
            }
        }
        return false;

    }

    public boolean sumOfNumberAndReverse3(int num) {
        if(num==0){
            return true;
        }
        int i=0;
        while (++i<num){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            if(Integer.parseInt(stringBuilder.reverse().toString())+i == num){
                System.out.println(i + "value ");
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        SumOfNumberAndReverse s = new SumOfNumberAndReverse();
        System.out.println(s.sumOfNumberAndReverse(181));
        System.out.println(s.sumOfNumberAndReverse(63));
        System.out.println(s.sumOfNumberAndReverse(443));
        System.out.println(s.sumOfNumberAndReverse(0));
    }
}
