package com.codegym;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3,5,1,2,6,9,7};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter x: ");
        int x = scanner.nextInt();
        System.out.println("Enter index: ");
        int index = scanner.nextInt();
        System.out.printf("%-20s%s", "Value: ", "");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "\t");
        }
        arr = Arrays.copyOf(arr, arr.length+1);
        for (int j = arr.length-1 ; j > index; j--){
            arr[j] = arr[j-1];
        }
        arr[index] = x;
        System.out.printf("\n%-20s%s", "New value: ", "");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "\t");
        }
    }
}