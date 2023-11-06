package com.codegym;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        Triangle triangle = new Triangle();
        System.out.println(triangle);

        triangle = new Triangle(2,2,2);
        System.out.println(triangle);

        triangle = new Triangle(3,4,5, "Red");
        System.out.println(triangle);
    }
}