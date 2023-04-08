package com.example.ch.vedio.demos.web;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class TestDateTime {
    public static void main(String[] args) {
        LocalDateTime t1 = LocalDateTime.of(2022, 7, 4, 10, 30, 22);
        LocalTime t2 = LocalTime.of(10, 30, 22);
        System.out.println(t1.plusDays(21));
        System.out.println(t1.minusDays(4));

        System.out.println(LocalDateTime.now());
        System.out.println(LocalTime.now());

        String date = "2022-06-30T10:30:22";
        String time = "16:32:50";
        LocalDateTime t3 = LocalDateTime.parse(date);
        LocalTime t4 = LocalTime.parse(time);
        System.out.println(t3.getYear());
        System.out.println(t4.getHour());
    }
}
