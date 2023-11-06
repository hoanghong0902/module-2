package com.codegym;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.binarySearch;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i : new int[]{2, 6, 8, 1, 7, 3, 2, 5}) {
            list.add(i);
        }
        Collections.sort(list);
        System.out.print("List:\t");
        for (Integer element : list){
            System.out.printf(element + "\t");
        }
        System.out.println("\nIndex of Element 6 = " + binarySearch(list,6));
    }

}