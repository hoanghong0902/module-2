package com.codegym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = -1;
        int choose = -1;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("______________________________________________________________________");
            System.out.println("Menu: ");
            System.out.println("1. Print a Rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print the isosceles triangle");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    createRectangle();
                    break;
                case 2:
                     do{
                         System.out.println("______________________________________________________________________");
                         System.out.println("Menu: Print the square triangle");
                         System.out.println("1. Print Square Triangle Top-Left");
                         System.out.println("2. Print Square Triangle Botton-Left");
                         System.out.println("3. Print Square Triangle Top-Right");
                         System.out.println("4. Print Square Triangle Botton-Right");
                         System.out.println("Enter your choose: ");
                         choose = scanner.nextInt();
                        switch (choose) {
                            case 1:
                                createSquareTriangleTopLeft();
                                break;
                            case 2:
                                createSquareTriangleBottonLeft();
                                break;
                            case 3:
                                createSquareTriangleTopRight();
                                break;
                            case 4:
                                createSquareTriangleBottonRight();
                                break;
                        }
                    }while (choose!=0);
                    break;
                case 3:
                    createIsoscelesTriangle();
                    break;
            }
        }while (choice != 0);
    }
    public static void createRectangle(){
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 10; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void createSquareTriangleBottonLeft(){
        for(int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                if(i >= j) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
    public static void createSquareTriangleBottonRight(){
        for(int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                if(j >= 7-i-1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void createSquareTriangleTopLeft(){
        for(int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                if(i <= j) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
    public static void createSquareTriangleTopRight(){
        for(int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                if(j >= i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void createIsoscelesTriangle(){
        for(int i = 0; i < 5; i++){
            for (int j = 0; j < 6; j++){
                if(j >= 6-i-1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            for (int k = 7; k < 14; k++) {
                if(i + 6 >= k) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}