package com.codegym;

import org.w3c.dom.Node;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>(11);
        myLinkedList.addFirst(10);
        myLinkedList.addLast(12);
        myLinkedList.add(1,9);
        myLinkedList.addLast(13);
        myLinkedList.addLast(14);
        myLinkedList.addLast(15);
        myLinkedList.addLast(16);

        myLinkedList.printList();

        myLinkedList.remove(1);
        myLinkedList.printList();

        Integer node = 10;
        System.out.println("\nRemove node " + node + " is: " + myLinkedList.remove(node));
        myLinkedList.printList();

        MyLinkedList<Integer>.Node node1 = myLinkedList.get(2);
        System.out.println("\nElement index of 2 = " + node1.getData());

        MyLinkedList<Integer>.Node node2 = myLinkedList.getFirst();
        System.out.println("\nFirst element of Linked List = " + node2.getData());

        MyLinkedList<Integer>.Node node3 = myLinkedList.getLast();
        System.out.println("\nLast element of Linked List = " + node3.getData());

        Integer node4 = 12;
        if(myLinkedList.contains(node4)){
            System.out.println("\nElement " + node4 + " is in Linked list");
        } else {
            System.out.println("\nElement " + node4 + " isn't in Linked list");
        }

        Integer node5 = 13;
        if(myLinkedList.indexOf(node5) != -1){
            System.out.println("\nIndex of element " + node5 + " = " + myLinkedList.indexOf(node5));
        } else {
            System.out.println("\nElement " + node5 + " isn't in Linked list");
        }

        MyLinkedList<Integer> newLinkedList = new MyLinkedList<>();
        newLinkedList.clone(myLinkedList);
        //System.out.println(newLinkedList.size());
        if (newLinkedList.size() == 0){
            System.out.println("\nLinked List is empty");
        } else {
            newLinkedList.printList();
        }

        myLinkedList.clear();
        if (myLinkedList.size() == 0){
            System.out.println("\nLinked List is empty");
        } else {
            myLinkedList.printList();
        }
    }
}