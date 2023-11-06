package com.codegym;

public class QuadraticEquation {
    int a, b, c;
    public QuadraticEquation(){}
    public QuadraticEquation(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getDiscriminant(){
        double delta = (b * b) - (4 * a * c);
        return delta;
    }
    public double getRoot1(){
        if(getDiscriminant()<0){
            return -1;
        }
        double root1 = (-b + Math.sqrt(getDiscriminant())) / (2*a);
        return root1;
    }
    public double getRoot2(){
        if(getDiscriminant()<0){
            return -1;
        }
        double root2 = (-b - Math.sqrt(getDiscriminant())) / (2*a);
        return root2;
    }
}
