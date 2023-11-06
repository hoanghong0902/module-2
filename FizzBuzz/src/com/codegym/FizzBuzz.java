package com.codegym;

public class FizzBuzz {
    public static String FizzBuzzTranslate(int number){
        String num = String.valueOf(number);
        if(number % 5 == 0 && number % 3 == 0){
            return "FizzBuzz";
        } else if (number % 3 == 0 || num.indexOf("3") != -1){
            return "Fizz";
        } else if (number % 5 == 0 || num.indexOf("5") != -1){
            return "Buzz";
        }
        return num;
    }
    public static String translateNumberToLetter(int number){
        int ones = number % 10;
        int tens = number / 10;
        return translateNumberTens(tens) + " " + translateNumberOnes(ones);
    }
    public static String translateNumberOnes(int number){
        switch (number){
            case 1:
                return "mot";
            case 2:
                return "hai";
            case 3:
                return "ba";
            case 4:
                return "bon";
            case 5:
                return "nam";
            case 6:
                return "sau";
            case 7:
                return "bay";
            case 8:
                return "tam";
            case 9:
                return "chin";
            default:
                return "";
        }
    }
    public static String translateNumberTens(int number){
        switch (number){
            case 1:
                return "Muoi";
            case 2:
                return "Hai muoi";
            case 3:
                return "Ba muoi";
            case 4:
                return "Bon muoi";
            case 5:
                return "Nam muoi";
            case 6:
                return "Sau muoi";
            case 7:
                return "Bay muoi";
            case 8:
                return "Tam muoi";
            case 9:
                return "Chin muoi";
            default:
                return "";
        }
    }
}
