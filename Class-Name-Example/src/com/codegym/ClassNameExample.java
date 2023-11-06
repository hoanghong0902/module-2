package com.codegym;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassNameExample {
    static final String CLASS_NAME = "^[CAP][0-9]{4}[GHIK]$";
    public static final String[] validClassName = new String[]{"C0223G", "A0323K"};
    public static final String[] inValidClassName = new String[]{"M0318G", "P0323A"};

    public static void main(String[] args) {

        for (String classname : validClassName){
            System.out.println("Class Name: " + classname + " is: " + validate(classname));
        }

        for (String classname : inValidClassName){
            System.out.println("Class Name: " + classname + " is: " + validate(classname));
        }
    }

    private static boolean validate(String className){
        Pattern pattern = Pattern.compile(CLASS_NAME);
        Matcher matcher = pattern.matcher(className);
        return matcher.matches();
    }
}