package com.test.leetcode;

//1701. Average Waiting Time

public class AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        if (customers.length<=0 ||  customers[0].length <=1){
            return 0.0;
        }
        int prevPrepTime = customers[0][1];
        int prevArrivalTime = customers[0][0];
        int sumVal = prevPrepTime;
        for (int i=1; i< customers.length;i++){
            int currArrivalTime = customers[i][0];
            int currPrepTime = customers[i][1];
            int arrivalTime = currArrivalTime - prevArrivalTime;
            int overallAT = prevPrepTime - arrivalTime;
            if (overallAT < 0) {
                overallAT = 0;
            }
            prevPrepTime = overallAT+currPrepTime;
            sumVal += prevPrepTime;
            prevArrivalTime = currArrivalTime;
        }
        return (sumVal / (float) customers.length);
    }

    public static void main(String[] args) {
        AverageWaitingTime averageWaitingTime = new AverageWaitingTime();
//        int[][] arg = {{}};
//        int[][] arg = {{1}};
        int[][] arg = {{1,2}};
//        int [][] arg = {{1, 2},{2, 5},{4, 3}};
//        int[][] arg = {{5, 2},{5, 4},{10, 3},{20, 1}};
        System.out.println(averageWaitingTime.averageWaitingTime(arg));
    }
}
