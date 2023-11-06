package com.codegym;

public class Shape {
    private String color = "Red";
    public Shape(){

    }
    public Shape(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String toString(){
        return "Shape color is " + getColor();
    }
}
