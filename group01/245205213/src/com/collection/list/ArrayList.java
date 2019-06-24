package com.collection.list;

import java.util.Arrays;

public class ArrayList implements List{
    public static void main(String[] args) {
        ArrayList arrList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            arrList.add(i);            
        }
        arrList.add(5, 10);
        System.out.println("size:" + arrList.size());
        System.out.println("get:" + arrList.get(2));
        System.out.println(arrList);
        System.out.println("remove:" + arrList.remove(2));
        System.out.println("remove:" + arrList.remove(5));
        System.out.println(arrList);
    }
    
    private int size = 0;
    private Object[] elementData = new Object[10];
    
    public String toString() {
        return Arrays.toString(elementData);
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
            elementData[size-1] = o;
        }
    }
    
    public void add(int index, Object o) {
        if (index > size) {
            System.out.println("索引超出范围");
            return;
        }
        Object[] copyArr = Arrays.copyOfRange(elementData, index, elementData.length);
        elementData[index] = o;
        elementData = Arrays.copyOf(elementData, elementData.length+1);
        System.arraycopy(copyArr, 0, elementData, index+1, copyArr.length);
        size++;
    }
    
    public Object get(int index) {
        if (index > size-1) {
            System.out.println("索引超出范围");
            return null;
        }
        return elementData[index];
    }
    
    public Object remove(int index) {
        if (index > size-1) {
            System.out.println("索引超出范围");
            return null;
        }
        Object target = elementData[index];
        Object[] copyArr = Arrays.copyOfRange(elementData, index+1, elementData.length);
        elementData = Arrays.copyOf(elementData, elementData.length-1);
        System.arraycopy(copyArr, 0, elementData, index, copyArr.length);
        size--;
        return target;
    }
    
    public int size() {
        return size;
    }
}
