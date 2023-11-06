package com.codegym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which month that you want to count days? ");
        int month = scanner.nextInt();
        String day;
        switch (month) {
            case 2:
                day = "28 or 29";
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = "31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = "30";
                break;
            default:
                System.out.print("Invalid input!");
                day = "0";
                break;
        }

        if (day != "0") {
            System.out.printf("The month '%d' has %s days!", month, day);
        }
    }
}