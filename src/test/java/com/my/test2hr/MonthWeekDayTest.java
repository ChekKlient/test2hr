package com.my.test2hr;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonthWeekDayTest {
    @Test
    public void checkJanuary2017(){
        MonthWeekday checkedDay= new
                MonthWeekday(Year.of(2017), Month.JANUARY);
        assertEquals(checkedDay.getWeekday(), Weekday.SUNDAY);

    }
    @Test
    public void checkMay2017() {
        MonthWeekday checkedDay = new
                MonthWeekday(Year.of(2017), Month.MAY);
        assertEquals(checkedDay.getWeekday(), Weekday.MONDAY);
    }

    @Test
    public void checkNextMonth(){
        MonthWeekday checkedDay = new
                MonthWeekday(Year.of(2017), Month.MAY);
        assertEquals(checkedDay.nextMonth().getMonth(), Month.JUNE);
        assertEquals(checkedDay.nextMonth().getMonth(), checkedDay.getMonth().plus(1));
    }

    @Test
    public void checkNextYear(){
        MonthWeekday checkedDay = new MonthWeekday(Year.of(2020), Month.JANUARY);
        assertEquals(checkedDay.nextYear().getYear(), Year.of(2021));
    }
}
