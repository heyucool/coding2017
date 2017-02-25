import java.util.*;



class SimpleArrayList
{
	//定义Object类型数组，
	//定义数组元素个数
	private Object [] elementData;
	private int size;
	
	//无参构造函数，默认生成长度为10的数组
	SimpleArrayList ()
	{
		this(10);
	}
	
	//参数构造函数，传入参数指定数组大小
	SimpleArrayList (int initialCapacity)
	{
		if(initialCapacity < 0)
			throw new IllegalArgumentException("IllegalArgumentException : 非法参数");
		 elementData =new Object [initialCapacity];

	}
	
	//添加指定位置的元素
	public void add (int index,Object element)
	{
		if(index > size || index < 0)
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException ：数组下标越界");
		ensureCapacity(size+1);
		//添加指定位置元素时
		//将该位置后的所有元素右移
		System.arraycopy(elementData,index,elementData,index+1,size-index);
		elementData[index] =element;
		size++;
	}

	//可调整数组的容量
	public void ensureCapacity (int mincapacity)
	{
		int oldlen =elementData.length;
		if(mincapacity > oldlen)
		{
			int newlen =(oldlen * 3)/2 + 1;
				if(mincapacity > newlen)
					newlen =mincapacity;
			elementData =Arrays.copyOf(elementData,newlen);
		}
	}

	public int size ()
	{
		return size;
	}

	//获取指定位置的元素
	public Object get(int index)
	{
		rangeCheck(index);
		return elementData[index];
	}
	
	//ArrayList允许放入null，因此分两种情况处理。
	public boolean remove (Object element)
	{
		if(element == null)
		{
			for(int i=0; i < size; i++)
			{
				if(elementData[i] == null)
					fastRemove(i);
				return true;
			}
		}else{
				for(int i=0; i < size; i++)
					if(element.equals(elementData[i]))
						fastRemove(i);
				return true;
		}
		return false;

	}

	//跳过了判断边界的处理，当找到匹配元素时调用此方法。
	public void fastRemove (int index)
	{
		int numMoved = size-index-1;
			if(numMoved > 0)
				System.arraycopy(elementData,index+1,elementData,index,numMoved);
			elementData[--size] = null;
		
	}

	public void clear()
	{
		elementData = null;
	}

	//判断传入的参数是否越界
	public void rangeCheck (int index)
	{
		if(index >=size || index < 0)
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException ：数组下标越界");
	}

	public boolean isEmpty ()
	{
		return size == 0;
	}
	
}

public class  MyArrayList
{
	public static void main(String[] args) 
	{

		SimpleArrayList sa =new SimpleArrayList();
		sa.add(0,"java001");
		sa.add(1,"java002");
		sa.add(2,"java003");
		sa.add(3,"java004");

		//System.out.println(sa.get(1));

		for(int i=0; i<sa.size(); i++)
		{
			System.out.print(sa.get(i));
		}

		System.out.println(sa.remove("java003"));

		for(int i=0; i<sa.size(); i++)
		{
			System.out.print(sa.get(i));
		}
		
	}
}

