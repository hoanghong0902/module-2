package com.codegym;

public class Main {
    public static void main(String[] args) {
        LazyPrimeFactorization thread1;
        OptimizedPrimeFactorization thread2;

//        System.out.println(isPrimeNumber(11));
        for (int i = 2; i < 200; i++){
            thread1 = new LazyPrimeFactorization(i);
            thread2 = new OptimizedPrimeFactorization(i);
            thread1.start();
            thread2.start();
        }
    }
}