package com.codegym;

public class Square extends Rectangle{
    public Square(){

    }
    public Square(double size){
        super(size, size);
    }
    public Square(double size, String color, boolean fill){
        super(size, size, color, fill);
    }
    public double getSize(){
        return getHeight();
    }
    public void setSize(double size){
        setHeight(size);
        setWidth(size);
    }
    public void setWidth(double width){
        setSize(width);
    }
    public void setHeight(double height){
        setSize(height);
    }
    public String toString(){
        return "A Square with size = "
                + getSize()
                + ", which a subclass of "
                + super.toString();
    }
}
