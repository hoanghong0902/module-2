package com.codegym;

public class Queue {
    private Node front;
    private Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enQueue(int data) {
        Node temp = new Node(data);
        if (isEmpty()) {
            this.front = this.rear = temp;
            this.rear.link = front;
            return;
        }
        this.rear = temp;
        this.rear.link = temp;
    }

    public Node deQueue() {
        if (this.front == null)
            return null;
        Node temp = this.front;
        this.front = this.front.link;
        if (this.front == null)
            this.rear = null;
        return temp;
    }

    public boolean isEmpty() {
        if (front == null && rear == null) {
            return true;
        }
        return false;
    }
}
