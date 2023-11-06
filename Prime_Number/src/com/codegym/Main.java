package com.codegym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the quantity Prime Number: ");
        int n = scanner.nextInt();
        int i = 2;
        int count = 0;
        System.out.println(n + " Prime Number: ");
        while (count < n){
            if(checkPrimeNumber(i) == true){
                System.out.print(i + ", ");
                count++;
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