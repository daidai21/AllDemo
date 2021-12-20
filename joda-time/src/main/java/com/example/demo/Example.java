package com.example.demo;

import org.joda.time.LocalDate;

public class Example {
    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println("计算上一个月的最后一天  " + now.minusMonths(1)
                .dayOfMonth()
                .withMaximumValue());

        System.out.println("计算从现在开始经过两个星期之后的日期  " + now.plusWeeks(2));
        System.out.println("计算从明天起 90 天以后的日期  " + now.plusDays(1).plusDays(90));

        System.out.println("计算五年前的第二个月的最后一天  " + now.minusYears(5)
                .monthOfYear()
                .setCopy(2)
                .dayOfMonth()
                .withMaximumValue());


    }
}
