package com.codegym;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread main is running");

        OddThread thread1 = new OddThread(new Thread());
        EvenThread thread2 = new EvenThread(new Thread());

        thread1.start();
        thread1.join();
        thread2.start();

        System.out.println("Thread main is over");
    }
}