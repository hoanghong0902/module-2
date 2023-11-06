package com.codegym;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTranslateTest {
    @Test
    public void FizzBuzzTest01(){
        int number = 3;
        String str = "Fizz";
        String result = FizzBuzz.FizzBuzzTranslate(number);
        assertEquals(str,result);
    }
    @Test
    public void FizzBuzzTest02(){
        int number = 5;
        String str = "Buzz";
        String result = FizzBuzz.FizzBuzzTranslate(number);
        assertEquals(str,result);
    }
    @Test
    public void FizzBuzzTest03(){
        int number = 15;
        String str = "FizzBuzz";
        String result = FizzBuzz.FizzBuzzTranslate(number);
        assertEquals(str,result);
    }
    @Test
    public void FizzBuzzTest04(){
        int number = 7;
        String str = "7";
        String result = FizzBuzz.FizzBuzzTranslate(number);
        assertEquals(str,result);
    }
    @Test
    public void FizzBuzzTest05(){
        int number = 203;
        String str = "Fizz";
        String result = FizzBuzz.FizzBuzzTranslate(number);
        assertEquals(str,result);
    }
    @Test
    public void FizzBuzzTest06(){
        int number = 99;
        String str = "Chin muoi chin";
        String result = FizzBuzz.translateNumberToLetter(number);
        assertEquals(str,result);
    }
    @Test
    public void FizzBuzzTest07(){
        int number = 13;
        String str = "Muoi ba";
        String result = FizzBuzz.translateNumberToLetter(number);
        assertEquals(str,result);
    }
    @Test
    public void FizzBuzzTest08(){
        int number = 50;
        String str = "Nam muoi ";
        String result = FizzBuzz.translateNumberToLetter(number);
        assertEquals(str,result);
    }
}
