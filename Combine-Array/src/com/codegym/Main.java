package com.codegym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[4];
        int[] arr2 = new int[5];
        int[] arr3 = new int[9];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value of arr1: ");
        for (int i=0; i<arr1.length; i++){
            System.out.println("arr1[" + (i+1) + "]: ");
            arr1[i] = scanner.nextInt();
            arr3[i] = arr1[i];
        }
        System.out.println("Enter value of arr2: ");
        for (int i=0; i<arr2.length; i++){
            System.out.println("arr2[" + (i+1) + "]: ");
            arr2[i] = scanner.nextInt();
            arr3[i+4] = arr2[i];
        }
        System.out.printf("%-20s%s","Value of arr3:", "");
        for (int j=0; j<arr3.length; j++){
            System.out.printf(arr3[j] + "\t");
        }
    }
}