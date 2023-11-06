package com.codegym;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter level of matrix: ");
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        int sum = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                arr[i][j] = ThreadLocalRandom.current().nextInt(1,100);
            }
        }
        System.out.println("Matrix: ");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++){
            sum += arr[i][i];
        }
        System.out.println("Sum Diagonal Matrix = " + sum);
    }
}