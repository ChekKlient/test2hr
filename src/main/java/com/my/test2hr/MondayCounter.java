package com.my.test2hr;

import java.time.Month;
import java.time.Year;

public class MondayCounter {
    public static void main(String[] args) {

        PeriodWeekdayCounter periodMondayCounter = new PeriodWeekdayCounter(
                new MonthWeekday(Year.of(1901), Month.JANUARY),
                new MonthWeekday(Year.of(2000), Month.DECEMBER),
                Weekday.SUNDAY
                );

        System.out.println(periodMondayCounter.getCountWeekday());

    }

}
