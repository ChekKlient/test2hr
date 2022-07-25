package com.my.test2hr;

public enum Weekday {
    MONDAY,
    TUESDAY,
    WEDNSDAY,
    THUSDAY,
    FRIDAY,
    SATERDAY,
    SUNDAY;

    public Weekday sheeft(int dayes){
        return Weekday.values()[(ordinal() + dayes) % Weekday.values().length];
    }

}
