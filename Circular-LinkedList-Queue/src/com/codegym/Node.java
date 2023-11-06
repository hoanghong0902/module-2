package com.codegym;

public class Node {
    public int data;
    public Node link;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node node) {
        this.link = node;
    }
}
