package com.codegym;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        myList.add(3);
        myList.add(5);
        myList.add(7);
        myList.add(1,2);
        myList.add(1,1);
//        myList.remove(0);

        System.out.println("My List:");
        myList.getElements();
        System.out.println("\nElement index of 4 : " + myList.get(4));
        System.out.println("\nIndex of Element 5 : " + myList.indexOf(5));
        System.out.println("\nList contain element 7 is: " + myList.contains(7));

//        System.out.println("List clear:");
//        myList.clear();
//        myList.getElements();

        MyList<Integer> list = new MyList<>();
        list.clone(myList);
        System.out.println("List clone:");
        list.getElements();
    }
}