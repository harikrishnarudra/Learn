package com.practice.learn;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class DurationDemo {

    public static void main(String[] args) {
        Temporal start = OffsetDateTime.now();
        Temporal end = start.plus(5, ChronoUnit.DAYS);
        Duration positiveDuration = Duration.between(start, end);
        Duration negativeDuration = Duration.between(end, start);
        System.out.println("Positive Duration in days is "+ positiveDuration.toDays() + ", Negative Duration in days is "+negativeDuration.toDays());
    }
}
