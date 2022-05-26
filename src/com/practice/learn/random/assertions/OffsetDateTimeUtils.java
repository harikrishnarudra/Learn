package com.practice.learn.random.assertions;

import java.time.Instant;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class OffsetDateTimeUtils {
    public static void main(String[] args) {
        OffsetDateTime offsetDateTime = Instant.now().atOffset(ZoneOffset.of("+0100"));
        System.out.println(offsetDateTime);
        System.out.println("=====");
        System.out.println(offsetDateTime.toZonedDateTime());
        System.out.println("=====");
        System.out.println(offsetDateTime.getOffset());

        System.out.println(offsetDateTime.toLocalDateTime());
        System.out.println(offsetDateTime.toLocalDateTime().toLocalDate());
        System.out.println(offsetDateTime.toLocalDateTime().toLocalDate().atTime(LocalTime.MIN));
        System.out.println(offsetDateTime.toLocalDateTime().toLocalDate().atTime(LocalTime.MIN).toInstant(offsetDateTime.getOffset()));

        System.out.println("===================================");
        offsetDateTime = Instant.now().atOffset(ZoneOffset.of("+0000"));
        System.out.println(offsetDateTime.toLocalDateTime().toLocalDate().atTime(LocalTime.MIN).toInstant(offsetDateTime.getOffset()));
    }
}
