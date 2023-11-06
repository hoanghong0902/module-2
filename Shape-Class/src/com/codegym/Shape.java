package com.codegym;

public class Shape {
    private String color = "green";
    private boolean filled = true;
    public Shape(){

    }
    public Shape(String color, boolean fill){
        this.color = color;
        this.filled = fill;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public boolean getFilled(){
        return filled;
    }
    public void setFilled(boolean fill){
        this.filled = fill;
    }
    public boolean isFilled(){
        return filled;
    }
    public String toString(){
        return "A Shape with color of "
                + getColor()
                + " and "
                + (isFilled() ? "filled" : "not filled");
    }
}
