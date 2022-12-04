package com.practice.leetcode.contest;

public class CountTime {
    public int countTime(String time) {
        int res = 1;
        String[] times = time.split(":");
        String mins = times[1];
        if (mins.charAt(0) == '?' && mins.charAt(1) == '?') {
            res = 60;
        }
        if (mins.charAt(0) == '?' && mins.charAt(1) != '?') {
            res = 6;
        }
        if (mins.charAt(0) != '?' && mins.charAt(1) == '?') {
            res = 10;
        }


        String hour = times[0];
        if(hour.charAt(0)=='?' && hour.charAt(1)=='?'){
            res *= 24;
        }
        if (hour.charAt(0) == '?' && hour.charAt(1) != '?') {
            if(hour.charAt(1) > '3'){
                res *= 2;
            }
            if (hour.charAt(1) <= '3') {
                res *=3;
            }

        }
        if ((hour.charAt(0) == '0' || (hour.charAt(0) == '1')) && hour.charAt(1) == '?') {
            res *= 10;
        }
        if (hour.charAt(0) == '2' && hour.charAt(1) == '?') {
            res *= 4;
        }
        return res;
    }

    public static void main(String[] args) {
        CountTime c = new CountTime();
        System.out.println(c.countTime("??:10"));
        System.out.println(c.countTime("?5:10"));
        System.out.println(c.countTime("?5:00"));
        System.out.println(c.countTime("0?:0?"));
        System.out.println(c.countTime("??:??"));
        System.out.println(c.countTime("?0:?0"));
        System.out.println(c.countTime("?3:1?"));
    }
}
