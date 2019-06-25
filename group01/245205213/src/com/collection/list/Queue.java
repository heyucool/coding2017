package com.collection.list;

public class Queue {
    LinkedList elementData = new LinkedList();
    
    public String toString() {
        return elementData.toString();
    }
    
    public void enQueue(Object o) {
        elementData.add(o);
    }
    
    public Object deQueue() {
//        int index = elementData.size()-1;
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
