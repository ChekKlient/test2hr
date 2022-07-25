package com.my.test2hr;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeekdayTest {
    @Test
    public void weekdayPlus7BustBeTheSame(){

        for (Weekday currentDay :
                Weekday.values()) {
            assertEquals(currentDay, currentDay.sheeft(7));
        }
    }

    @Test
    public void mondayPlus6MustBeSunday(){
           assertEquals(Weekday.MONDAY.sheeft(6), Weekday.SUNDAY);
    }
}
