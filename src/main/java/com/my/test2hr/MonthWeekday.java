package com.my.test2hr;

import java.time.Month;
import java.time.Year;

public class MonthWeekday implements Comparable<MonthWeekday>{
    private Year year;
    private Month month;
    private Weekday weekday;
    private static final MonthWeekday baseMonthWeekday = new MonthWeekday(Year.of(1900), Month.JANUARY, Weekday.MONDAY);

    private MonthWeekday(Year year, Month month, Weekday weekday) {
        this.year = year;
        this.month = month;
        this.weekday = weekday;
    }

    public MonthWeekday(Year year, Month month) {
        this.year = year;
        this.month = month;
        this.weekday = findWeekday(year, month);
    }

    public Year getYear() {
        return year;
    }

    public Month getMonth() {
        return month;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    public MonthWeekday nextMonth(){
        int weekdayShift = month.length(year.isLeap());
        if (month.getValue() == 12) return new MonthWeekday(year.plusYears(1), month.plus(1), weekday.sheeft(weekdayShift));
        else return new MonthWeekday(year, month.plus(1), weekday.sheeft(weekdayShift));
    }

    public MonthWeekday nextYear(){
        Year nextYear = year.plusYears(1);
        boolean plusYearIsLeap = month.getValue() > Month.FEBRUARY.getValue() ? nextYear.isLeap() : year.isLeap();
        return new MonthWeekday(nextYear, month, weekday.sheeft(plusYearIsLeap ? 366 : 365));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null)
            return getYear().equals(((MonthWeekday)obj).getYear()) && getMonth().equals(((MonthWeekday)obj).getMonth());
        return false;
    }

    @Override
    public int compareTo(MonthWeekday other) {
        if (other == null) return 1;
        if (year.compareTo(other.getYear())!=0) return year.compareTo(other.getYear());
        return month.compareTo(other.getMonth());
    }

    private Weekday findWeekday(Year year, Month month){
        int numberOfLeapYears = 0;
        int numberOfYears = 0;
        int numberOfLastYearDayes = 0;
        for (Year currentYear = baseMonthWeekday.getYear();
             currentYear.isBefore(year);
             currentYear = currentYear.plusYears(1)
                ) {
            numberOfLeapYears += currentYear.isLeap() ? 1 : 0;
            numberOfYears ++;
        }
        for (Month currentMonth = Month.JANUARY;
             !currentMonth.equals(month);
             currentMonth = currentMonth.plus(1))
            numberOfLastYearDayes += currentMonth.length(year.isLeap());
        return baseMonthWeekday.getWeekday().sheeft(365 * numberOfYears + numberOfLeapYears + numberOfLastYearDayes);
    }

}
