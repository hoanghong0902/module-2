package com.codegym;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(4.5));
        shapes.add(new Square(5));
        shapes.add(new Rectangle(2,3));
        for (Shape shape : shapes){
            System.out.println(shape.getArea());
            if(shape instanceof Square){
                ((Square) shape).howToColor();
            }
        }
    }
}