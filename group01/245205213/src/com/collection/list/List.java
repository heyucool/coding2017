package com.collection.list;

public interface List<E> {
    
    public boolean add(E e);
    
    public boolean add(int index, E e);

    public E get(int index);
    
    public E remove(int index);
    
    public boolean clear();
    
    public int size();
    
}
