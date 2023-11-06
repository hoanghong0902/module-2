package com.codegym;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;

    public MyLinkedList() {
        head=null;
    }

    public MyLinkedList(Object data) {
        head = new Node(data);
        numNodes++;
    }

    class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }
    public void add(int index, E element){
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++){
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }
    public void addFirst(E element){
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }
    public void addLast(E element){
        Node holder = new Node(element);
        Node temp = head;
        if(numNodes == 0){
            head = holder;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = holder;
        }
        numNodes++;
    }
    public Node get(int index){
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }
    public Node getFirst(){
        Node temp = head;
        return temp;
    }
    public Node getLast(){
        Node temp = head;
        for (int i = 0; i < numNodes-1; i++){
            temp = temp.next;
        }
        return temp;
    }
    public void remove(int index){
        Node temp = head;
        if(index == 0){
            head = temp.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        numNodes--;
    }
    public boolean remove(E element){
        Node temp = head;
        if(temp.data == element){
            remove(0);
            return true;
        } else {
            for (int i = 0; i < numNodes; i++) {
                if (temp.next.data == element) {
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }
    public int size(){
        return numNodes;
    }
    public void printList(){
        System.out.print("\nMy list:");
        Node temp = head;
        for (int i = 0; i < numNodes; i++){
            System.out.print("\t" + temp.getData());
            temp = temp.next;
        }
    }
    public void clone(MyLinkedList e){

        for (int i = 0; i < e.size(); i++){
            this.addLast((E) e.get(i).data);
        }
    }
    public boolean contains(E element){
        Node temp = head;
        for (int i = 0; i < numNodes; i++){
            if(temp.data == element){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public int indexOf(E element){
        Node temp = head;
        for (int i = 0; i < numNodes; i++){
            if(temp.data == element){
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }
    public void ensureCapacity(int minCapacity){
        numNodes += minCapacity;
    }
    public void clear(){
        Node temp = head;
        int i = 0;
        while (numNodes != 0){
           this.remove(i);
        }
    }
}
