package com.codegym;

public class Main {
    public static void main(String[] args) {
        NumberGenerator numberGenerator1 = new NumberGenerator("Thread 1");
        NumberGenerator numberGenerator2 = new NumberGenerator("Thread 2");

        System.out.println("Main thread running... ");

        numberGenerator1.start();
        numberGenerator2.start();

        System.out.println("Main thread stopped!!! ");
    }
}