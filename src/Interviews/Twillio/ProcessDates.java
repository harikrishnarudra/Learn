package Interviews.Twillio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessDates {
    public static List<String> preprocessDate(List<String> dates) {
        List<String> result = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for (String s:dates) {
            String[] eles = s.split(" ");
            String day = eles[0];
            String justDay = "";
            if(day.length()==4){
                justDay=day.substring(0,2);
            }
            if (day.length() == 3) {
                justDay = day.substring(0, 1);
            }
            s = s.replace(day,justDay);
            Date date = new Date(s);
            result.add(formatter.format(date));
        }
        return result;
    }

    public static void main(String[] args) {
        /*java.util.Date date = new Date("1 Dec 2012");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String format = formatter.format(date);
        System.out.println(format);*/
        List<String> list = preprocessDate(List.of("6th Jun 1933", "26th May 1960", "20th Sep 1958", "16th Mar 2068", "25th May 1912", "16th Dec 2018",
                "6th Jun 1933", "26th Dec 2061", "4th Nov 2030", "28th Jul 1963"));
        list.stream().forEach(System.out::println);

    }
}
