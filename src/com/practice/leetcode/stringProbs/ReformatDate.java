package com.practice.leetcode.stringProbs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1507. Reformat Date
 * Given a date string in the form Day Month Year, where:
 *
 * Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
 * Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
 * Year is in the range [1900, 2100].
 * Convert the date string to the format YYYY-MM-DD, where:
 *
 * YYYY denotes the 4 digit year.
 * MM denotes the 2 digit month.
 * DD denotes the 2 digit day.
 */
public class ReformatDate {

    /**
     * Seems to be most efficient. Characters picking and building. Avoided string operations.
     */

    private static final Map<String, String> MONTHS = new HashMap<>();

    static {
        MONTHS.put("Jan", "01");
        MONTHS.put("Feb", "02");
        MONTHS.put("Mar", "03");
        MONTHS.put("Apr", "04");
        MONTHS.put("May", "05");
        MONTHS.put("Jun", "06");
        MONTHS.put("Jul", "07");
        MONTHS.put("Aug", "08");
        MONTHS.put("Sep", "09");
        MONTHS.put("Oct", "10");
        MONTHS.put("Nov", "11");
        MONTHS.put("Dec", "12");
    }

    public String reformatDate3(String date) {
        int dateLen = date.length();
        char[] resChars = new char[10];
        resChars[4] = '-';
        resChars[7] = '-';

        // Year
        for (int i = 0; i < 4; i++) {
            resChars[3 - i] = date.charAt(dateLen - 1 - i);
        }

        // Month
        String monthVal = MONTHS.get(date.substring(dateLen - 8, dateLen - 5));
        resChars[5] = monthVal.charAt(0);
        resChars[6] = monthVal.charAt(1);

        // Date
        if (Character.isDigit(date.charAt(1))) {
            resChars[8] = date.charAt(0);
            resChars[9] = date.charAt(1);
        } else {
            resChars[8] = '0';
            resChars[9] = date.charAt(0);
        }

        return new String(resChars);
    }


    public String reformatDate(String date) {
        Map<String, String> monthMap = Map.ofEntries(Map.entry("Jan","01"),
                Map.entry("Feb", "02"), Map.entry("Mar", "03"), Map.entry("Apr", "04"),
                Map.entry("May", "05"), Map.entry("Jun", "06"), Map.entry("Jul", "07"),
                Map.entry("Aug", "08"), Map.entry("Sep", "09"), Map.entry("Oct", "10"),
                Map.entry("Nov", "11"), Map.entry("Dec","12"));
        String[] words = date.split(" ");
        String fMonth = "";
        String fDay = "";
        fMonth = monthMap.get(words[1]);
        String day = words[0];
        if(day.length()==4){
            fDay = day.substring(0,2);
        }
        else {
            fDay = day.substring(0, 1);
            fDay = "0"+fDay;
        }
        return words[2] + "-" + fMonth + "-" + fDay;
    }

    public String reformatDate2(String date) {
        String[] months = new String[]{"None","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        String[] days = new String[]{"0th", "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th","13th", "14th", "15th",
        "16th","17th", "18th", "19th", "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th", "31st"};
        String[] words = date.split(" ");
        String fMonth = "";
        String fDay = "";
        for(int i=0;i< months.length; i++){
            if(words[1].equalsIgnoreCase(months[i])){
                if(i<=9){
                    fMonth = "0"+i;
                }else{
                    fMonth = "" + i;
                }
            }
        }
        for (int i = 0; i < days.length; i++) {
            if(words[0].equalsIgnoreCase(days[i])){
                if (i <= 9) {
                    fDay = "0" + i;
                } else {
                    fDay = "" + i;
                }
            }
        }
        return words[2]+"-"+fMonth+"-"+fDay;
    }

    public static void main(String[] args) {
        ReformatDate rf = new ReformatDate();
        System.out.println(rf.reformatDate("20th Oct 2052"));
        System.out.println(rf.reformatDate("9th Jan 2052"));
    }
}
