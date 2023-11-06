package com.codegym;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter level of matrix: ");
        int n = scanner.nextInt();
        float[][] a = new float[n][n];
        float max = a[0][0];
        System.out.printf("Matrix: \n");
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                a[i][j] = ThreadLocalRandom.current().nextFloat()*100+1;
                if(max < a[i][j]){
                    max = a[i][j];
                }
            }
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.printf("%.2f \t",a[i][j]);
            }
            System.out.println();

        }
        System.out.println("Max = " + max);
    }
}