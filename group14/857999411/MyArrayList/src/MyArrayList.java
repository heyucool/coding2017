import java.util.*;



class SimpleArrayList
{
	//����Object�������飬
	//��������Ԫ�ظ���
	private Object [] elementData;
	private int size;
	
	//�޲ι��캯����Ĭ�����ɳ���Ϊ10������
	SimpleArrayList ()
	{
		this(10);
	}
	
	//�������캯�����������ָ�������С
	SimpleArrayList (int initialCapacity)
	{
		if(initialCapacity < 0)
			throw new IllegalArgumentException("IllegalArgumentException : �Ƿ�����");
		 elementData =new Object [initialCapacity];

	}
	
	//���ָ��λ�õ�Ԫ��
	public void add (int index,Object element)
	{
		if(index > size || index < 0)
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException �������±�Խ��");
		ensureCapacity(size+1);
		//���ָ��λ��Ԫ��ʱ
		//����λ�ú������Ԫ������
		System.arraycopy(elementData,index,elementData,index+1,size-index);
		elementData[index] =element;
		size++;
	}

	//�ɵ������������
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

	//��ȡָ��λ�õ�Ԫ��
	public Object get(int index)
	{
		rangeCheck(index);
		return elementData[index];
	}
	
	//ArrayList�������null����˷������������
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

	//�������жϱ߽�Ĵ������ҵ�ƥ��Ԫ��ʱ���ô˷�����
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

	//�жϴ���Ĳ����Ƿ�Խ��
	public void rangeCheck (int index)
	{
		if(index >=size || index < 0)
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException �������±�Խ��");
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

