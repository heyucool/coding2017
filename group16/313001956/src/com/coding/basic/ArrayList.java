package com.coding.basic;

public class ArrayList implements List {

	private int size = 0;

	private Object[] elementData = null;

	private final int cap = 10;// 扩容增量

	public ArrayList() {
		elementData = new Object[100];
	}
	
	public ArrayList(int initialCapacity ) {
		elementData = new Object[initialCapacity];
	}

	public void add(Object o) {
		if (elementData.length <= size)
			IncreaseCap();
		elementData[size] = o;

		size++;

	}

	public void add(int index, Object o) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		if (elementData.length <= size)
			IncreaseCap();

		System.arraycopy(elementData, index, elementData, index + 1, size - index);
		elementData[index] = o;
		size++;
	}

	public Object get(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();

		return elementData[index];
	}

	public Object remove(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		Object o = elementData[index];
		System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
		size--;
		return o;
	}

	public int size() {
		return size;
	}
	
	public Iterator iterator(){
		return null;
	}

	// 扩容方法
	private void IncreaseCap() {
		Object[] icrelementData = new Object[elementData.length + cap];
		System.arraycopy(elementData, 0, icrelementData, 0, elementData.length);
		elementData = icrelementData;

	}
}