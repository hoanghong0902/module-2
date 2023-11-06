package com.codegym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cols of matrix: ");
        int cols = scanner.nextInt();
        System.out.println("Enter rows of matrix: ");
        int rows = scanner.nextInt();
        int[][] arr = new int[cols][rows];
        for (int i = 0; i < cols; i++){
            for (int j = 0; j < rows; j++){
                System.out.printf("\nEnter arr[%d][%d]: ", i, j);
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println("\nMatrix: ");
        for (int i = 0; i < cols; i++){
            for (int j = 0; j < rows; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\nMin = " + minArr(arr));
    }
    public static int minArr(int arr[][]){
        int min = arr[0][0];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                if (min > arr[i][j]){
                    min = arr[i][j];
                }
            }
        }
        return min;
    }
}