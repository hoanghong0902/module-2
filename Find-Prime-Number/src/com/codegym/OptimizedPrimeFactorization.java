package com.codegym;

public class OptimizedPrimeFactorization extends Thread{
    private int number;

    public OptimizedPrimeFactorization(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        if (isPrimeNumber(number) || number == 2){
            System.out.println("Optimized Prime Factorization: " + number);
        }
    }
    private boolean isPrimeNumber(int number){
        for (int i = 2; i <= (int) (Math.sqrt(number)); i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
