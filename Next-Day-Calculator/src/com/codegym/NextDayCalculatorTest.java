package com.codegym;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextDayCalculatorTest {
    @Test
    @DisplayName("Testing 01/01/2018 to 02/01/2018")
    public void testNextDay01(){
        int day=1,month=1,year=2018;
        int[] example={2,1,2018};
        NextDayCalculator nextDayCalculator=new NextDayCalculator();
        nextDayCalculator.setDayMothYear(day,month,year);
        int[] result=nextDayCalculator.getNextDayMonthYear();
        assertArrayEquals(example,result);
    }
    @Test
    @DisplayName("Testing 31/01/2018 to 01/02/2018")
    public void testNextDay02(){
        int day=31,month=1,year=2018;
        int[] example={1,2,2018};
        NextDayCalculator nextDayCalculator=new NextDayCalculator();
        nextDayCalculator.setDayMothYear(day,month,year);
        int[] result=nextDayCalculator.getNextDayMonthYear();
        assertArrayEquals(example,result);
    }
    @Test
    @DisplayName("Testing 30/04/2018 to 01/05/2018")
    public void testNextDay03(){
        int day=30,month=4,year=2018;
        int[] example={1,5,2018};
        NextDayCalculator nextDayCalculator=new NextDayCalculator();
        nextDayCalculator.setDayMothYear(day,month,year);
        int[] result=nextDayCalculator.getNextDayMonthYear();
        assertArrayEquals(example,result);
    }
    @Test
    @DisplayName("Testing 29/02/2020 to 01/03/2020")
    public void testNextDay04(){
        int day=29,month=2,year=2020;
        int[] example={1,3,2020};
        NextDayCalculator nextDayCalculator=new NextDayCalculator();
        nextDayCalculator.setDayMothYear(day,month,year);
        int[] result=nextDayCalculator.getNextDayMonthYear();
        assertArrayEquals(example,result);
    }
    @Test
    @DisplayName("Testing 31/12/2018 to 01/01/2019")
    public void testNextDay05(){
        int day=31,month=12,year=2018;
        int[] example={1,1,2019};
        NextDayCalculator nextDayCalculator=new NextDayCalculator();
        nextDayCalculator.setDayMothYear(day,month,year);
        int[] result=nextDayCalculator.getNextDayMonthYear();
        assertArrayEquals(example,result);
    }
}
