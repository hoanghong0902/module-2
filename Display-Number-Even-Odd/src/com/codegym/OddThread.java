package com.codegym;

public class OddThread extends Thread{

    public OddThread(Thread thread) {
        System.out.println("OddThread is creating");
    }

    @Override
    public void run() {
        try {
        for (int i = 1; i <= 9; i+=2) {
            System.out.println("Odd thread: " + i);

            sleep(1000);
        }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("OddThread is over");
    }
}
