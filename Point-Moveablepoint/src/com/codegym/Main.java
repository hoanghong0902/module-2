package com.codegym;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(2,3);
        System.out.println(point);
        System.out.println();
        MoveablePoint moveablePoint = new MoveablePoint(3,4,1,2);
        System.out.println(moveablePoint);

        moveablePoint.move();
        System.out.println(moveablePoint);
        moveablePoint.move();
        System.out.println(moveablePoint);
    }
}