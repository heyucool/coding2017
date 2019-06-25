package com.collection.list;

import java.util.Arrays;

public class ArrayList implements List {
   
    private int size = 0;
    private Object[] elementData = new Object[10];

    public String toString() {
        Object[] oArr = new Object[size];
        oArr = Arrays.copyOf(elementData, size);
        return Arrays.toString(oArr);
    }

    public void add(Object o) {
        if (size < 10) {
            for (int i = 0; i < elementData.length; i++) {
                if (elementData[i] == null) {
                    elementData[i] = o;
                    size++;
                    return;
                }
            }
        } else {
            elementData = Arrays.copyOf(elementData, ++size);
            elementData[size - 1] = o;
        }
    }

    public void add(int index, Object o) {
        if (index > size) {
            System.out.println("索引超出范围");
//            return;
        }
        Object[] copyArr = Arrays.copyOfRange(elementData, index, elementData.length);
        elementData[index] = o;
        elementData = Arrays.copyOf(elementData, elementData.length + 1);
        System.arraycopy(copyArr, 0, elementData, index + 1, copyArr.length);
        size++;
    }

    public Object get(int index) {
        if (index > size - 1) {
            System.out.println("索引超出范围");
//            return null;
        }
        return elementData[index];
    }

    public Object remove(int index) {
        if (index > size - 1) {
            System.out.println("索引超出范围");
            return null;
        }
        Object target = elementData[index];
        Object[] copyArr = Arrays.copyOfRange(elementData, index + 1, elementData.length);
        elementData = Arrays.copyOf(elementData, elementData.length - 1);
        System.arraycopy(copyArr, 0, elementData, index, copyArr.length);
        size--;
        return target;
    }

    public int size() {
        return size;
    }
}
