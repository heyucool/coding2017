package com.collection.list;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;
    
    public boolean add(E e) {
        if (first == null) {
            first = new Node<E>();
            first.data = e;
            last = first;
            size++;
        } else {
            Node<E> node = new Node<E>();
            node.data = e; 
            node.pre = last;
            last.next = node;
            last = node;
            size++;
        }
        return true;
    }
    
    public E getFirst() {
        return first.data;
    }
    
    public E getLast() {
        return last.data;
    }
    
    public E get(int index) {
        isNotElementIndex(index);
        return getNode(first,index).data;
    }

    private void isNotElementIndex(int index) {
        if (index > size-1 || index < 0) {
            throw new NoSuchElementException();
        }
    }
    
    private Node<E> getNode(Node<E> n, int index) {
        if (index == 0) {
            return n;
        }
        return getNode(n.next, index-1);
    }
    
    public E remove(int index) {
        isNotElementIndex(index);
        Node<E> node = getNode(first, index);
        E e = node.data;
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.data = null;
        node.next = null;
        node.pre = null;
        size--;
        return e;
    }
    
    public int size() {
        return size;
    }
    
    public void addFirst(E e) {
        Node<E> node = new Node<E>();
        node.next = first;
        node.data = e;
        first.pre = node;
        first = node;
        size++;
    }
    
    public E removeFirst() {
        E e = first.data;
        Node<E> next = first.next;
        first.next = null;
        first.data = null;
        first = next;
        size--;
        return e;
    }
    
    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> pre;
    }

    public boolean add(int index, E e) {
        Node<E> node = new Node<E>();
        Node<E> pre = getNode(first, index).pre;
        node.data = e;
        node.next = getNode(first, index);
        node.next.pre = node;
        node.pre = pre;
        node.pre.next = node;
        size++;
        return true;
        
    }
    
    public String toString() {
        int index = 0;
        Object[] objs = new Object[size];
        Node<E> node = first;
        while (node != null) {
            objs[index++] = node.data;
            node = node.next;
        }
        return Arrays.toString(objs);
    }


    @Override
    public boolean clear() {
        // TODO Auto-generated method stub
        return true;
    }
}
