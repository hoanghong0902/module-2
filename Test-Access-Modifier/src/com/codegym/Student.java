package com.codegym;

public class Student {
    public String name = "John";
    public String classes = "C03";
    public Student(){

    }
    public Student(String n, String c){
        this.name = n;
        this.classes = c;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getClasses() {
        return classes;
    }
    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
