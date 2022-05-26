package com.practice.leetcode.ggle;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    private int size;
    private double sumVal;
//    private Queue queue;
    private ArrayDeque<Integer> queue;

    public MovingAverage(int size) {
        this.size = size;
//        queue = new LinkedList<>();
        queue = new ArrayDeque<>(this.size);
    }

    public double next(int val) {
        if (queue.size() == this.size) {
//            this.sumVal -= queue.remove();
            this.sumVal -= queue.poll();
        }
        this.sumVal += val;
//        queue.add(val);
        queue.offer(val);
        return this.sumVal / queue.size();
    }
}

class TestMvg{
    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }
}
