package com.codegym;


public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle(4,6);
        shapes[1] = new Circle(3);
        shapes[2] = new Square(5);

        for (Shape shape : shapes){
            System.out.println(shape);
        }

        for (Shape shape : shapes){
            shape.resize(2);
        }

        for (int i=0;i< shapes.length;i++){

            System.out.println(shapes[i].getArea());
        }
    }
}