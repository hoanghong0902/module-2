package com.codegym;

public class Square extends Shape implements Colorable{
    private double side;
    public Square(){

    }
    public Square(double side){
        this.side = side;
    }
    public Square(double side, String color, boolean fill){
        super(color, fill);
        this.side = side;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }

    public double getSide(){
        return side;
    }
    public void setSide(double side){
        this.side = side;
    }
    public double getArea(){
        return side * side;
    }
    public double getPerimeter(){
        return 4 * side;
    }
    public String toString(){
        return "A Square with size = "
                + getSide()
                + ", which a subclass of "
                + super.toString();
    }
}
