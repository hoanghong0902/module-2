package com.codegym;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayLists = new ArrayList<>();
        arrayLists.add(10);
        arrayLists.add(11);
        arrayLists.add(12);
        arrayLists.add(13);
        arrayLists.add(14);
        arrayLists.add(15);

        System.out.println("Integer ArrayList: ");
        show(arrayLists);

        reverseArrayIntegerStack(arrayLists);
        System.out.println("\nReverse Integer ArrayList: ");
        show(arrayLists);

        String str = "I LOVE YOU";
        System.out.println("String: " + str);
        System.out.println("\nReverse String: " + reverseStringStack(str));

    }
    public static void reverseArrayIntegerStack(ArrayList<Integer> e){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < e.size(); i++){
            stack.push(e.get(i));
            e.set(i, stack.pop());
        }
    }
    public static String reverseStringStack(String e){
        Stack<String> stack = new Stack<>();
        String str = "";
        for (int i = 0; i < e.length(); i++){
            stack.push(String.valueOf(e.charAt(i)));
        }
        while (!stack.isEmpty()){
            str += stack.pop();
        }
        return str;
    }
    public static void show(ArrayList<?> e){
        for (int i = 0; i < e.size(); i++){
            System.out.print(e.get(i) + " ");
        }
    }
}