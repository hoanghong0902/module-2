package com.codegym;

public class LazyPrimeFactorization extends Thread{
    private int number;

    public LazyPrimeFactorization(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        int count = 0;
        for (int i = 1; i <= number; i++){
            if(number % i == 0){
                count++;
            }
        }
        if (count == 2){
            System.out.println("Lazy Prime Factorization: " + number);
        }
    }
}
