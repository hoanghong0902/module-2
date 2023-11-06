package com.codegym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3,5,1,2,6,9,7};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter x: ");
        int x = scanner.nextInt();
        System.out.printf("%-20s%s", "Value: ", "");
        int index = -1;
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "\t");
            if(x == arr[i]){
                index = i;
            }
        }
        if(index != -1){
            System.out.println("Index of X: " + index);
        } else {
            System.out.println("X is not found");
        }
        for (int j = index; j < arr.length-1; j++){
            arr[j] = arr[j+1];
        }
        arr[arr.length-1] = 0;
        System.out.printf("%-20s%s", "New value: ", "");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "\t");
        }
    }
}