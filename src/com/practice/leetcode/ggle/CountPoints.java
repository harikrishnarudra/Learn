package com.practice.leetcode.ggle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountPoints {
    public int countPoints(String rings) {
        if(rings.length()%2!=0){
            return 0;
        }
        Set<Character> resultSet = new HashSet<>();
        Map<Character, Set<Character>> map = new HashMap<>();
        for(int i=1;i<rings.length();i+=2){
            char c = rings.charAt(i);
            Set<Character> s = map.getOrDefault(c, new HashSet<>());
            s.add(rings.charAt(i - 1));
            map.put(c, s);
            if(!s.isEmpty() && s.size()==3){
                resultSet.add(c);
            }
        }
        return resultSet.size();

    }

    /**
     * From the comments
     */
    private int RED = 4;
    private int BLUE = 2;
    private int GREEN = 1;

    public int countPoints2(String rings) {
        int count = 0;
        int[] rodBitMasks = new int[10];

        for (int i = 0; i < rings.length() - 1; i += 2) {
            char color = rings.charAt(i);
            int pos = Character.getNumericValue(rings.charAt(i + 1));

            switch (color) {
                case 'R':
                    rodBitMasks[pos] |= RED;
                    break;
                case 'B':
                    rodBitMasks[pos] |= BLUE;
                    break;
                case 'G':
                    rodBitMasks[pos] |= GREEN;
                    break;
                default:
                    break;
            }
        }

        for (int rodBitMask : rodBitMasks) {
            if (rodBitMask == 7) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountPoints c = new CountPoints();
        System.out.println(c.countPoints("R1G1B1R2"));
        System.out.println(c.countPoints("R3G2B1"));
        System.out.println(c.countPoints("B0B6G0R6R0R6G9"));
        System.out.println(c.countPoints("B0R0G0R9R0B0G0"));

    }
}
