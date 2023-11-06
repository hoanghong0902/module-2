package com.codegym;

public class EvenThread extends Thread{
    public EvenThread(Thread thread) {
        System.out.println("EvenThread is creating");
    }

    @Override
    public void run() {
        try {
            for (int i = 2; i <= 10; i+=2) {
                System.out.println("Even thread: " + i);

                sleep(1500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("EvenThread is over");
    }
}
