package com.practice.leetcode.contest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class ProductQueries {
    private static final int MOD = 1000000007;
    public int[] productQueries(int n, int[][] queries) {
        int[] twoPowers = new int[32];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<32;i++){
            if((n & (1<<i) )>0){
                stack.push((1<<i));
                n = n >> 1;
            }
        }
        return twoPowers;
    }



//    private int[] powersOfTwo;
    private static final int NUM = 64;
    private static final int VALUE = (int) Math.pow(10, 9) + 7;
    public int[] productQueries2(int n, int[][] queries) {
        int[] powersOfTwo = new int[NUM];
        for(int i=0;i<NUM;i++){
            if((int) Math.pow(2, i) > VALUE){
                powersOfTwo[i] = (int) Math.pow(2, i) % VALUE + 1;
            }else {
                powersOfTwo[i] = (int) Math.pow(2, i);
            }
        }
//        powersOfTwo[32] = (int) Math.pow(2, 32)-1;
        Stack<Integer> stack = new Stack<>();
        while(n>0){
            for(int i=0;i<NUM;i++){
                if(powersOfTwo[i] == n){
                    stack.push(i);
                    n = 0;
                    break;
                }else if(powersOfTwo[i] > n){
                    stack.push(i-1);
                    n = n- powersOfTwo[i-1];
                    if(n>0) {
                        i = -1;
                    }else{
                        break;
                    }
                }
            }
        }
        int[] arr = new int[stack.size()];
        int k=0;
        while(!stack.isEmpty()){
            arr[k++] = stack.pop();
        }
        int[] result = new int[queries.length];
        int j = 0;
        for(int[] q:queries){
            int sum = 0;
            for(int p=q[0];p<=q[1];p++){
                sum += arr[p];
            }
            result[j++] = powersOfTwo[sum];
            /*if (powersOfTwo[sum] > VALUE) {
                result[j++] = powersOfTwo[sum] % VALUE + 1;
            } else {
                result[j++] = powersOfTwo[sum];
            }*/
        }
        return result;
    }

    public static void main(String[] args) {
        ProductQueries p = new ProductQueries();
        /*int[] res = p.productQueries(15, new int[][]{{0,1},{2,2},{0,3}});
        Arrays.stream(res).forEach(System.out::println);
        System.out.println("=======");
        res = p.productQueries(2, new int[][]{{0, 0}});
        Arrays.stream(res).forEach(System.out::println);*/
        System.out.println("=======");
        int[] res = p.productQueries(919, new int[][]{{5, 5}, {4, 4}, {0, 1}, {1, 5}, {4, 6}, {6, 6}, {5, 6}, {0, 3}, {5, 5}, {5, 6}, {1, 2}, {3, 5}, {3, 6}, {5, 5}, {4, 4}, {1, 1}, {2, 4}, {4, 5}, {4, 4}, {5, 6}, {0, 4}, {3, 3}, {0, 4}, {0, 5}, {4, 4}, {5, 5}, {4, 6}, {4, 5}, {0, 4}, {6, 6}, {6, 6}, {6, 6}, {2, 2}, {0, 5}, {1, 4}, {0, 3}, {2, 4}, {5, 5}, {6, 6}, {2, 2}, {2, 3}, {5, 5}, {0, 6}, {3, 3}, {6, 6}, {4, 4}, {0, 0}, {0, 2}, {6, 6}, {6, 6}, {3, 6}, {0, 4}, {6, 6}, {2, 2}, {4, 6}});
        Arrays.stream(res).forEach(System.out::println);
//        int[] res = p.productQueries(508, new int[][]{{0, 4}, {5, 6}, {5, 6}, {0, 3}, {4, 6}, {3, 3}, {1, 3}, {5, 5}, {3, 3}, {5, 5}, {0, 6}, {4, 6}, {4, 4}, {5, 5}, {4, 6}, {2, 3}, {4, 6}, {4, 4}, {2, 4}, {3, 6}, {2, 6}, {0, 6}, {5, 5}, {2, 2}, {6, 6}, {4, 4}, {4, 4}, {6, 6}, {1, 2}, {0, 1}, {6, 6}, {0, 2}, {6, 6}, {0, 4}, {6, 6}, {0, 6}, {6, 6}, {0, 4}, {0, 3}, {1, 4}, {4, 5}, {4, 5}, {6, 6}, {3, 3}, {3, 6}, {3, 3}, {2, 6}, {3, 5}, {1, 6}, {6, 6}, {6, 6}, {0, 3}, {4, 5}, {4, 4}, {4, 4}, {1, 1}, {3, 6}, {4, 4}, {0, 3}, {2, 6}, {3, 5}, {4, 6}, {6, 6}, {2, 3}, {4, 6}, {3, 5}, {5, 6}, {1, 2}, {2, 2}, {1, 3}, {5, 6}, {4, 6}, {2, 5}, {3, 6}, {1, 1}, {1, 2}, {0, 6}, {6, 6}, {1, 1}, {2, 4}, {1, 2}, {2, 5}, {3, 6}, {4, 5}, {0, 3}, {0, 5}, {1, 1}, {2, 6}, {0, 3}, {0, 0}, {5, 6}, {5, 5}, {0, 4}});
//        Arrays.stream(res).forEach(System.out::println);

    }
}
