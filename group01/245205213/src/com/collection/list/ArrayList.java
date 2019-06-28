package com.collection.list;

import java.util.Arrays;
import java.util.Collection;

public class ArrayList<E> implements List<E> {
   
    private int size = 0;
    private Object[] elementData = new Object[10];

    public ArrayList() {
        System.out.println("test1");
    }
    public ArrayList(Collection<? extends E> c) {
        size = c.size();
        elementData = c.toArray();
    }
    
    private void ensureCapacity() {
        if (elementData.length+1 > size) {
            elementData = Arrays.copyOf(elementData, size*3/2+1);
        } 
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size)) ;
    }

    public boolean add(E e) {
        ensureCapacity();
        elementData[size++] = e;
        return true;
    }

    public boolean add(int index, E e) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        ensureCapacity();
        System.arraycopy(elementData, index, elementData, index+1, size-index);
        elementData[index] = e;
        size++;
        return true;
    }

    public E get(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return elementData(index);
    }

    @SuppressWarnings("unchecked")
    private E elementData(int index) {
        return (E) elementData[index];
    }

    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E oldValue = elementData(index);
        System.arraycopy(elementData, index+1, elementData, index, size-index-1);
        elementData[--size] = null;
        return oldValue;
    }

    public int size() {
        return size;
    }


    public boolean clear() {
        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = null;
        }
        size = 0;
        return true;
    }
}
