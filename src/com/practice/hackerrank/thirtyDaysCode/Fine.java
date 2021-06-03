package com.practice.hackerrank.thirtyDaysCode;

import java.util.Scanner;
import static java.lang.Math.max;
import static java.lang.StrictMath.abs;

public class Fine {

    public static  int calculateFine(int day_returned, int month_returned, int year_returned,
                                     int day_due, int month_due, int year_due){
        if(year_returned==year_due){
            if (month_returned == month_due) {
                if (day_returned <= day_due) {
                    return 0;
                } else if (day_returned > day_due) {
                    return 15*abs(day_due-day_returned);
                }

            } else if (month_returned > month_due) {
                return 500* abs(month_due-month_returned);

            } else if (month_returned < month_due) {
                return 0;
            }
        }else if(year_returned > year_due){
            return 10000;
        } else if (year_returned < year_due) {
            return 0;
        }

        return 0;
    }

    public static void main(String[] args) {
        int day_returned = 0, month_returned=0, year_returned =0, day_due=0, month_due=0, year_due=0;
        Scanner scanner = new Scanner(System.in);
        day_returned = scanner.nextInt();
        month_returned = scanner.nextInt();
        year_returned = scanner.nextInt();
        day_due = scanner.nextInt();
        month_due = scanner.nextInt();
        year_due = scanner.nextInt();

//        System.out.println(""+ day_returned+" "+ month_returned+" "+year_returned);
//        System.out.println("" + day_due + " " + month_due + " " + year_due);
        System.out.println(calculateFine(day_returned,month_returned,year_returned, day_due,month_due,year_due));
    }
}
