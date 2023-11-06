package com.codegym;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Hoang", "C02");
        student1.setName("Hong");
        student1.setClasses("C04");
        System.out.println(student1.getName());
        System.out.println(student1.getClasses());
    }
}