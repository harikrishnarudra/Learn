package com.practice.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestRectangleArea {
    /**
     * BRUTE FORCE
     * Find out where is next smaller and previous smaller on the right and left-hand sides respectively
     * Do the math of (nextSmaller-prevSmaller-1)*A[i], deduce max from each element
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        int maxArea = 0;
        if(len==1){
            return heights[0];
        }
        for(int i=0;i<len;i++){
            int left =i, right = i;
            while(left>=0 && heights[left] >= heights[i]){
                left--;
            }
            while (right < len && heights[right] >= heights[i]) {
                right++;
            }
            int currArea = (right - left - 1) * heights[i];
            maxArea = Math.max(currArea, maxArea);
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int maxArea = 0;
        if (len == 1) {
            return heights[0];
        }
        int[] ns = this.nextSmallerElements(heights);
        int[] ps = this.prevSmallerElements(heights);

        for(int i=0;i<len;i++){
            maxArea = Math.max(maxArea, (ns[i]-ps[i]-1)*heights[i]);
        }
        return maxArea;
    }

    public int[] nextSmallerElements(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (deque.isEmpty()) {
                result[i] = arr.length;
            } else {
                while (!deque.isEmpty() && arr[deque.peek()] > arr[i]) {
                    deque.pop();
                }
                result[i] = deque.isEmpty() ? arr.length : deque.peek();
            }
            deque.push(i);
        }
        return result;
    }


    public int[] prevSmallerElements(int[] arr) {
        int[] result = new int[arr.length];
//        Stack<Integer> s = new Stack<>();
        Deque<Integer> s = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (s.isEmpty()) {
                result[i] = -1;
            } else {
                while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                    s.pop();
                }
                result[i] = s.isEmpty() ? -1 : s.peek();
            }
            s.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        LargestRectangleArea l = new LargestRectangleArea();
        /*int[] res = l.prevSmallerElements(new int[]{2, 1, 5, 6, 2, 3});
        Arrays.stream(res).forEach(System.out::println);
        System.out.println("=======");
        res = l.nextSmallerElements(new int[]{2, 1, 5, 6, 2, 3});
        Arrays.stream(res).forEach(System.out::println);*/
        System.out.println(l.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}) + "----" + l.largestRectangleArea2(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(l.largestRectangleArea(new int[]{4, 2, 1, 5, 6, 3, 2, 4}) + "----" + l.largestRectangleArea2(new int[]{4, 2, 1, 5, 6, 3, 2, 4}));
        System.out.println(l.largestRectangleArea(new int[]{4, 2, 1, 5, 6, 3, 2, 4, 2}) + "----" + l.largestRectangleArea2(new int[]{4, 2, 1, 5, 6, 3, 2, 4, 2}));
        System.out.println(l.largestRectangleArea(new int[]{2, 4}) + "----" + l.largestRectangleArea2(new int[]{2, 4}));
        System.out.println(l.largestRectangleArea(new int[]{1, 1}) + "----" + l.largestRectangleArea2(new int[]{1, 1}));
        System.out.println(l.largestRectangleArea(new int[]{2}) + "----" + l.largestRectangleArea2(new int[]{2}));
    }
}
