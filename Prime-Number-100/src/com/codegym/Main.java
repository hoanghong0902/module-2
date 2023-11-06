package com.codegym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 2;
        System.out.println("Prime Number less than 100: ");
        while (i < 100){
            if(checkPrimeNumber(i) == true){
                System.out.print(i + ", ");
            }
            i++;
        }
    }
    public static boolean checkPrimeNumber(int n){
        int count = 0;
        for (int i = 1; i <= n; i++){
            if(n % i == 0){
                count++;
            }
        }
        if(count == 2){
            return true;
        }
        return false;
    }
}