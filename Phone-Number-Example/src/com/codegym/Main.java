package com.codegym;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static final String PHONE_NUMBER = "^[(]+[8]+[4]+[)]+[-]+[(]+[0]+\\d{9}+[)]$";
    static final String[] validPhoneNumber = new String[]{"(84)-(0978489648)", "(84)-(0772416447)"};
    static String[] inValidPhoneNumber = new String[]{"(a8)-(22222222)", "(84-(22b22222)", "(84)-(9978489648)"};

    public static void main(String[] args) {
        for (String phoneNumber : validPhoneNumber){
            System.out.println("Phone Number: " + phoneNumber + " is: " + validate(phoneNumber));
        }
        for (String phoneNumber : inValidPhoneNumber){
            System.out.println("Phone Number: " + phoneNumber + " is: " + validate(phoneNumber));
        }
    }

    private static boolean validate(String phoneNumber){
        Pattern pattern = Pattern.compile(PHONE_NUMBER);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}