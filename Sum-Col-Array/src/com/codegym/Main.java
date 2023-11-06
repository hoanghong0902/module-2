package com.codegym;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter rows of matrix: ");
        int row = scanner.nextInt();
        System.out.println("Enter cols of matrix: ");
        int col = scanner.nextInt();
        System.out.println("Enter column you need to sum: ");
        int n = scanner.nextInt();
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                arr[i][j] = ThreadLocalRandom.current().nextInt(1,100);
            }
        }
        System.out.println("Matrix: ");
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Sum column " + n + " = " + sumCol(arr, n));
    }
    public static int sumCol(int arr[][], int n){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i][n];
        }
        return sum;
    }
}