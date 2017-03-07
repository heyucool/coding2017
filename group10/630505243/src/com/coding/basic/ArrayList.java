package com.coding.basic;

public class ArrayList implements List {
	
	private int size = 0;
	
	private Object[] elementData = new Object[100];
	
	public void add(Object o){
		if(o!=null){
			elementData[size] = o;
			if(size<100-1){
				size++;
			}else{
				Object[] temp = new Object[(size+1)+100];
				System.arraycopy(elementData, 0, temp, 0, size);
				elementData = temp;
				size++;
			}
		}
		
	}
	public void add(int index, Object o){
		if(index<elementData.length-1){
			if(index<size-1){
			//新增元素位置处于数组内部
				Object tmp = elementData[index];
				//新增元素位置后的所有元素后移一位
				Object[] temps = new Object[elementData.length+1];
				System.arraycopy(elementData, 0, temps, 0, elementData.length);
				for(int i=temps.length;i>=index;i--){
					if(i==index){
						temps[index] = tmp;
					}else{
						temps[i]=temps[i-1];
					}
				}
				elementData = temps;
				
			}else if(index>=size-1){
				elementData[size] = o;
			}
		}else{
			//新增元素位置处于数组右边界
			Object[] temp = new Object[(size+1)+100];
			System.arraycopy(elementData, 0, temp, 0, size);
			elementData = temp;
			elementData[index] = o;
		}
		size++;
	}
	
	public Object get(int index){
		if(index<=elementData.length){
			return elementData[index];
		}else{
			return null;
		}
	}
	
	public Object remove(int index){
		Object rtnObj = null;
		if(index<=size){
			if(index<elementData.length-1){
				rtnObj = elementData[index];
				for(int i=index;i<size;i++){
					elementData[i] = elementData[i+1];
				}
				elementData[size] = null;
				size--;
				return rtnObj;
				
			}else if(index==elementData.length-1){
				rtnObj = elementData[size];
				elementData[size] = null;
				size--;
				return rtnObj;
			}
		}
		return null;
	}
	
	public int size(){
		return this.size;
	}
	
	class ArrayIterator implements Iterator{
		private ArrayList array;
		private int position = 0;
		public ArrayIterator(ArrayList list){
			this.array = list;
		}
		@Override
		public boolean hasNext() {
			if(array.get(position)!=null){
				this.position++;
				return true;
			}else
				return false;
		}
		@Override
		public Object next() {
			return array.get(position-1);
		}
		
	}
	public Iterator iterator(){
		ArrayIterator aIterator = new ArrayIterator(this);
		return aIterator;
	}
	
}
