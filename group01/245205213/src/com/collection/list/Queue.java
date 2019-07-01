package com.collection.list;

public class Queue<E> {
    LinkedList<E> elementData = new LinkedList<E>();
    
    public String toString() {
        return elementData.toString();
    }
    
    public void enQueue(E o) {
        elementData.add(o);
    }
    
    public Object deQueue() {
        Object o = elementData.removeFirst();
        return  o;
    }
    
    public boolean isEmpty() {
        if (elementData.size() == 0) {
            return true;
        }
        return false;
    }
    
    public int size() {
        return elementData.size();
    }
}
