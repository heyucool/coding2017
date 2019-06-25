package com.collection.list;

public class Stack {
    private ArrayList elementData = new ArrayList();
    
    public String toString() {
        return elementData.toString();
    }
    
    public void push(Object o) {
          elementData.add(o);
    }
    
    public Object pop() {
        int indexLast = elementData.size()-1;
        Object o = elementData.get(indexLast);
        elementData.remove(indexLast);
        return o;
    }
    
    public Object peek() {
        int indexLast = elementData.size()-1;
        Object o = elementData.get(indexLast);
        return o;
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
