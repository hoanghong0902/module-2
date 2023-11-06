package com.codegym;

public class NumberGenerator implements Runnable{
    private final String name;
    private Thread thread;

    public NumberGenerator(String name) {
        this.name = name;
        thread = new Thread(this, name);
        System.out.println("My thread created " + name);
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        System.out.println("Thread " + name + " is run");
        try {
            for (int i = 0; i < 10; i++){
                System.out.println(name + ": number = " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread " + name + " is over");
    }
    public void start() {
        System.out.println("Starting " + name);
        if (thread == null) {
            thread = new Thread(this, name);
            thread.start();
        }
    }
}
