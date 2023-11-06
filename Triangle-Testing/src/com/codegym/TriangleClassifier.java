package com.codegym;

public class TriangleClassifier {
    private double side1;
    private double side2;
    private double side3;

    public TriangleClassifier(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public boolean equilateralTriangle(){
        if (side1 == side2 && side1 == side3){
            return true;
        }
        return false;
    }
    public boolean isoscelesTriangle(){
        if (side1 == side2 || side1 == side3 || side2 == side3){
            return true;
        }
        return false;
    }
    public boolean nonTriangle(){
        if ((side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1)
            && side1 > 0 && side2 > 0 && side3 > 0){
            return true;
        }
        return false;
    }
}
