package com.collection.list;

import java.util.Arrays;

public class LinkedList implements List {
    
    public String toString() {
        int index = 0;
        Object[] objs = new Object[size];
        Node node = head;
        while (node != null) {
            objs[index++] = node.data;
            node = node.next;
        }
        return Arrays.toString(objs);
    }
    private Node head;
    private int size = 0;
    
    //如果存在头结点
    public void add(Object o) {
        if (head == null) {
            head = new Node();
            head.data = o;
            size++;
        } else {
            Node node = getLastNode(head); 
            node.next = new Node();
            node.next.data = o;
            size++;
        }
    }
    
    private Node getLastNode(Node n) {
        if (n.next != null) {
            return getLastNode(n.next);
        }
        return n/*.next = new Node() */;
    }
    
    public Object get(int index) {
        if (index > size-1 || index < 0) {
            System.out.println("索引超出范围！");
//            return null;
        }
        return getNode(head,index).data;
    }
    
    private Node getNode(Node n, int index) {
        if (index > 0) {
            return getNode(n.next, index-1);
        } else if (index < 0) {
            return null;
        }
        return n;
    }
    
    public Object remove(int index) {
        Object o = getNode(head, index).data;
        getPrevNode(head, index).next = getNextNode(head, index);
        size--;
        return o;
    }
    
    private Node getPrevNode(Node n, int index) {
        if (index > 1) {
            return getPrevNode(n.next, index-1);
        }
        return n;
    }
    
    private Node getNextNode(Node n, int index) {
        if (index > size-1) {
            System.out.println("索引超出范围！");
            return null;
        }
        return getNode(head, index).next;
    }
    
    public int size() {
        return size;
    }
    
    public void addFirst(Object o) {
//        Node node = head;
//        head.next = node;
//        head.data = o;
//        size++;
        Node node = new Node();
        node.next = head;
        node.data = o;
        head = node;
        size++;
    }
    
    public Object removeFirst() {
        Object o = head.data;
        Node node = head.next;
        head = node;
        size--;
        return o;
    }
    
    private static class Node {
        Object data;
        Node next;
        Node prev;
    }

    public void add(int index, Object o) {
        Node node = new Node();
        node.data = o;
        node.next = getNode(head, index);
        getPrevNode(head, index).next = node;
        size++;
        
    }
}
