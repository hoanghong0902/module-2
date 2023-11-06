package com.codegym;

public class Fan {

    int speed = SLOW;
    int radius = 5;
    String color = "blue";
    boolean status = false;
    private static final int SLOW = 1;
    private static final int MEDIUM = 2;
    private static final int FAST = 3;
    public Fan(){

    };
    public Fan(int speed, int radius, String color, boolean status){
        this.speed = speed;
        this.radius = radius;
        this.color = color;
        this.status = status;
    }
    private int getSpeed(){
        return speed;
    }
    private int setSpeed(int speed){
        return this.speed = speed;
    }
    private int getRadius(){
        return radius;
    }
    private int setRadius(int radius){
        return this.radius = radius;
    }
    private String getColor(){
        return color;
    }
    private String setColor(String color){
        return this.color = color;
    }
    private boolean getStatus(){
        return status;
    }
    private boolean setStatus(boolean status){
        return this.status = status;
    }
    public String toString(){
        if(status == true){
            return ("Fan is on {speed: " + speed + ", color: " + color + ", radius: " + radius + "}");
        }
        return "Fan is off";
    }
}
