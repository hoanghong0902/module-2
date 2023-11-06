package com.codegym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = scanner.nextInt();
        System.out.print("Enter b: ");
        int b = scanner.nextInt();
        System.out.print("Enter c: ");
        int c = scanner.nextInt();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        double delta = quadraticEquation.getDiscriminant();
        System.out.println("Delta = " + delta);
        if(delta < 0) {
            System.out.println("The equation has no solution");
        } else if (delta == 0) {
            System.out.println("The equation has only solution: " + quadraticEquation.getRoot1());
        } else {
            System.out.println("The equation has solution 1: " + quadraticEquation.getRoot1());
            System.out.println("The equation has solution 2: " + quadraticEquation.getRoot2());
        }
    }
}