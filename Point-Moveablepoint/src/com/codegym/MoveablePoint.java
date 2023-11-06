package com.codegym;

public class MoveablePoint extends Point{
    private static double xSpeed = 1;
    private static double ySpeed = 1;
    public MoveablePoint(){

    }

    public MoveablePoint(double xSpeed, double ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public MoveablePoint(double x, double y, double xSpeed, double ySpeed){
        super(x,y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(double xSpeed, double ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public double[] getSpeed(){
        double[] a = {xSpeed,ySpeed};
        return a;
    }
    public MoveablePoint move(){
        double x = getX();
        double y = getY();
        super.setX(x+xSpeed);
        super.setY(y+ySpeed);
        return this;
    }
    public String toString(){
        return "MoveablePoint: x = "
                + getX()
                + ", y = "
                + getY()
                + " which xSpeed = "
                + getxSpeed()
                + ", ySpeed = "
                + getySpeed();
    }
}
