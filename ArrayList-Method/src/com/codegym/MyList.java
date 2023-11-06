package com.codegym;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    public static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public int getSize() {
        return size;
    }

    public void getElements() {
        for (Object element : elements){
            if(element != null) {
                System.out.print(element + "\t");
            }
        }
    }


    public void ensureCapacity(int minCapacity){
        int newSize = elements.length + minCapacity;
        elements = Arrays.copyOf(elements,newSize);
    }
    public void add(int index, E element){
        if(index < size) {
            size++;
            for (int i = size - 1; i >= index; i--) {
                elements[i + 1] = elements[i];
            }
            elements[index] = element;
        }
    }
    public void remove(int index){
        for (int i = index; i < size; i++){
            elements[i] = elements[i+1];
        }
        size--;
    }
    public void add(E element){
        if (size == elements.length) {
            ensureCapacity(1);
        }
        elements[size++] = element;
    }
    public void clone(MyList element){
        for (int i=0;i<element.size;i++){
            this.add((E) element.get(i));
        }
    }
    public boolean contains(E element){
        for (Object ele : elements){
            if(ele == element){
                return true;
            }
        }
        return false;
    }
    public int indexOf(E element){
        for (int i = 0; i < size; i++){
            if(elements[i] == element){
                return i;
            }
        }
        return -1;
    }
    public E get(int index){
        return (E) elements[index];
    }
    public void clear(){
        Object[] element = new Object[0];
        this.elements = element;
    }
}
