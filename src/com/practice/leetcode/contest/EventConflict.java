package com.practice.leetcode.contest;

public class EventConflict {
    public boolean haveConflict(String[] event1, String[] event2) {
        int startEvent = Integer.parseInt(event1[0].replace(":", ""));
        int endEvent = Integer.parseInt(event1[1].replace(":", ""));

        int secStartEvent = Integer.parseInt(event2[0].replace(":", ""));
        int secEndEvent = Integer.parseInt(event2[1].replace(":", ""));
        return (startEvent <= secStartEvent && secStartEvent <= endEvent)
                || (startEvent <= secEndEvent && secEndEvent <= endEvent)
                || (secStartEvent <= startEvent && secEndEvent >= endEvent)
                || (secEndEvent <= endEvent && secEndEvent>= startEvent);

    }

    public static void main(String[] args) {
        EventConflict conflict = new EventConflict();
        System.out.println(conflict.haveConflict(new String[]{"01:15", "02:00"}, new String[]{"02:00", "03:00"}));
        System.out.println(conflict.haveConflict(new String[]{"01:00", "02:00"}, new String[]{"01:20", "03:00"}));
        System.out.println(conflict.haveConflict(new String[]{"10:00", "11:00"}, new String[]{"14:00", "15:00"}));
        System.out.println(conflict.haveConflict(new String[]{"14:13","22:08"}, new String[]{"02:40","08:08"}));
        System.out.println(conflict.haveConflict(new String[]{"15:19", "17:56"}, new String[]{"14:11", "20:02"}));

    }
}
