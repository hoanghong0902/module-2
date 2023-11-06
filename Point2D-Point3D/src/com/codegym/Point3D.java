package com.codegym;

public class Point3D extends Point2D{
    private double z = 1.0;
    public Point3D(){

    }
    public Point3D(double z){
        this.z = z;
    }
    public Point3D(double x, double y, double z){
        super(x,y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setXYZ(double x, double y, double z){
        setX(x);
        setY(y);
        this.z = z;
    }
    public double[] getXYZ(){
        double x = getX();
        double y = getY();
        double[] arr = {x,y,z};
        return arr;
    }
    public String toString() {
        return "Point3D: x = "
                + getX()
                + ", y = "
                + getY()
                + ", z = "
                + getZ();
    }
}
