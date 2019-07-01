package com.collection.list;

import java.util.EmptyStackException;

public class Stack<E> {
    private ArrayList<E> elementData = new ArrayList<E>();
    
    public String toString() {
        return elementData.toString();
    }
    
    public E push(E e) {
          elementData.add(e);
          return e;
    }
    
    public synchronized E pop() {
        int indexLast = elementData.size()-1;
        isNotIndex(indexLast);
        E e = elementData.get(indexLast);
        elementData.remove(indexLast);
        return e;
    }
    
    public synchronized E peek() {
        int indexLast = elementData.size()-1;
        isNotIndex(indexLast);
        E e = elementData.get(indexLast);
        return e;
    }

    private void isNotIndex(int indexLast) {
        if (indexLast == -1) {
            throw new EmptyStackException();
        }
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public int size() {
        return elementData.size();
    }
}
