package com.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CountUnguarded {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        Set<String> wallSet = new HashSet();
        for (int i = 0; i < walls.length; i++) {
            int[] wall = walls[i];
            String s = "" + wall[0] + "" + wall[1];
            wallSet.add(s);

        }
        Set<String> blocks = new HashSet();
        for (int i = 0; i < guards.length; i++) {
            int[] guardPos = guards[i];
            int p = guardPos[0], q = guardPos[1];
            int pp = p, ppp = pp, qq = q, qqq = q;
            while (pp > 0) {
                pp -= 1;
                String s = "" + pp + "" + q;
                if (wallSet.contains(s)) {
                    break;
                } else {
                    blocks.add(s);
                }
            }
            while (ppp < m) {
                ppp += 1;
                String s = "" + ppp + "" + q;
                if (wallSet.contains(s)) {
                    break;
                } else {
                    blocks.add(s);
                }
            }
            while (qq > 0) {
                qq -= 1;
                String s = "" + p + "" + qq;
                if (wallSet.contains(s)) {
                    break;
                } else {
                    blocks.add(s);
                }
            }
            while (qqq < n) {
                qqq += 1;
                String s = "" + p + "" + qqq;
                if (wallSet.contains(s)) {
                    break;
                } else {
                    blocks.add(s);
                }
            }
        }
        System.out.println(blocks);
        System.out.println(wallSet);
        return -1;
    }
}
