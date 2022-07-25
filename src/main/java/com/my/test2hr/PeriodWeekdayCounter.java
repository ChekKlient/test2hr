package com.my.test2hr;

public class PeriodWeekdayCounter {
    private MonthWeekday startPeriod;
    private MonthWeekday endPeriod;
    private Weekday weekday;
    private int countWeekday;

    public PeriodWeekdayCounter(MonthWeekday startPeriod, MonthWeekday endPeriod, Weekday weekday) {
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.weekday = weekday;
        this.countWeekday = countWeekday();
    }

    public MonthWeekday getStartPeriod() {
        return startPeriod;
    }

    public MonthWeekday getEndPeriod() {
        return endPeriod;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    public int getCountWeekday() {
        return countWeekday;
    }

    private int countWeekday() {
        int countWeekday = 0;
        for (MonthWeekday currentMonthWeekday = startPeriod;
             currentMonthWeekday.compareTo(endPeriod) <=0 ;
             currentMonthWeekday = currentMonthWeekday.nextMonth()){
            if (currentMonthWeekday.getWeekday().equals(weekday)) countWeekday++;
        }
        return countWeekday;
    }

}
