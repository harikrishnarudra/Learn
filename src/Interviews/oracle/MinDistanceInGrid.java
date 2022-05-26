package Interviews.oracle;

import java.util.ArrayList;
import java.util.List;

public class MinDistanceInGrid {
    static int minDistance(int[][] arr){
        List<List<Integer>> aPoints = new ArrayList<>();
        List<List<Integer>> bPoints = new ArrayList<>();
        int m = arr.length;
        int n= arr[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                List<Integer> point = new ArrayList<>();
                point.add(i);
                point.add(j);
                if(arr[i][j] == 'A'){
                    aPoints.add(point);
                }
                if (arr[i][j] == 'B') {
                    bPoints.add(point);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int k=0;k<aPoints.size();k++){
            List<Integer> aPoint = aPoints.get(k);
            for(int j=0;j<bPoints.size();j++){
                List<Integer> bPoint = bPoints.get(j);
                int val = Math.abs(bPoint.get(0)-aPoint.get(0)) + Math.abs(bPoint.get(1) - aPoint.get(1));
                res = Math.min(val, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{'B', 'A', 0, 0}, {'A', 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 'B', 'B'}};
        int res = minDistance(arr);
        System.out.println(res);
    }
}
