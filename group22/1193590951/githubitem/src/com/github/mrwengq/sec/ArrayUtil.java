package com.github.mrwengq.sec;

public class ArrayUtil {
	
	/**
	 * 给定一个整形数组a , 对该数组的值进行置换
		例如： a = [7, 9 , 30, 3]  ,   置换后为 [3, 30, 9,7]
		如果     a = [7, 9, 30, 3, 4] , 置换后为 [4,3, 30 , 9,7]
	 * @param origin
	 * @return
	 */
	public void reverseArray(int[] origin){ //为了避免过多使用空间，没有采用空间复制的方式进行置换
 		int len = origin.length;
		int temp = 0;
		for(int i = len ; i>0;i--){			//len - i 是从小到大    
			if(len - i > (int) (len-1)/2){
				break;
			}
			temp = origin[len-i];			
			origin[len-i] = origin[i-1];	//i-1是从大到小
			origin[i-1] = temp;
			
		}
		
	}
	
	/**
	 * 现在有如下的一个数组：   int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5}   
	 * 要求将以上数组中值为0的项去掉，将不为0的值存入一个新的数组，生成的新数组为：   
	 * {1,3,4,5,6,6,5,4,7,6,7,5}  
	 * @param oldArray
	 * @return
	 */
	
	public int[] removeZero(int[] oldArray){
		int removeNum =0;
		for(int i = 0;i<oldArray.length;i++){
			if(0==oldArray[i]){
				removeNum++;
			}
		}
		int[] newArray = new int[oldArray.length-removeNum];
		int j = 0;
		for(int i = 0;i<oldArray.length;i++){
			if(0!=oldArray[i]){
				newArray[j] = oldArray[i];
				j++;
			}
		}
		return newArray;
	}
	
	/**
	 * 给定两个已经排序好的整形数组， a1和a2 ,  创建一个新的数组a3, 使得a3 包含a1和a2 的所有元素， 并且仍然是有序的
	 * 例如 a1 = [3, 5, 7,8]   a2 = [4, 5, 6,7]    则 a3 为[3,4,5,6,7,8]    , 注意： 已经消除了重复
	 * @param array1
	 * @param array2
	 * @return
	 */
	
	public int[] merge(int[] array1, int[] array2){
		int newArrayLen = array1.length+array2.length;
		for(int i = 0;i<array1.length;i++){   //查找两个数组中重复元素；没重复一次新的数组长度减1
			for(int j =0;j<array2.length;j++){
				if(array1[i]==array2[j]){
					newArrayLen--;
				} 
			}
		}
		int index1 = 0; //数组1的下标
		int index2 = 0;//数组2的下标
		int[] newArray = new int[newArrayLen];
		for(int i = 0;i<newArray.length;i++){
			if(index1>array1.length-1){
				newArray[i] = array2[index2++];
				break;
			}
			if(index2>array2.length-1){
				newArray[i] = array1[index1++];
				break;
			}
			if(array1[index1]>array2[index2]){
				newArray[i] = array2[index2++];
			}else if(array1[index1]<array2[index2]){
				newArray[i] = array1[index1++];
			}else{
				newArray[i] = array1[index1++];
				index2++;
			}
		}
		return  newArray;
	}
	/**
	 * 把一个已经存满数据的数组 oldArray的容量进行扩展， 扩展后的新数据大小为oldArray.length + size
	 * 注意，老数组的元素在新数组中需要保持
	 * 例如 oldArray = [2,3,6] , size = 3,则返回的新数组为
	 * [2,3,6,0,0,0]
	 * @param oldArray
	 * @param size
	 * @return
	 */
	public int[] grow(int [] oldArray,  int size){
		int newArraylen = oldArray.length+size;
		int[] newArray = new int[newArraylen];
		for(int i = 0;i<oldArray.length;i++){
			newArray[i] = oldArray[i];
		}
		
		return newArray;
	}
	
	/**
	 * 斐波那契数列为：1，1，2，3，5，8，13，21......  ，给定一个最大值， 返回小于该值的数列
	 * 例如， max = 15 , 则返回的数组应该为 [1，1，2，3，5，8，13]
	 * max = 1, 则返回空数组 []
	 * @param max
	 * @return
	 */
	public int[] fibonacci(int max){
		if(max<=0){
			throw new RuntimeException("max不能小于等于0");
		}
		if(1==max){
			return new int[0];
		}
		if(2==max){
			return new int[]{1,1};
		}
		int[] temp = new int[100];
		temp[0] = 1;
		temp[1] = 1;
		int len = 2 ;
		
		while(true){
			int next = temp[len-1]+temp[len-2]; 
			if(next>max){
				break;
			}
			if(len-1>temp.length){
				temp = copyAddArray(temp);
			}
			temp[len] = next;
			len++;
			
		}
		int[] fbn = new int[len];
		System.arraycopy(temp, 0, fbn, 0, len);
		return fbn;
	}
	private int[] copyAddArray(int elementData[]) { //对数组扩容 增加量为原长度3/4
		int ob[] = new int[elementData.length+(elementData.length * 3) / 4];
		System.arraycopy(elementData ,0, ob, 0,elementData.length);
		return ob;
	}
	
	/**
	 * 返回小于给定最大值max的所有素数数组
	 * 例如max = 23, 返回的数组为[2,3,5,7,11,13,17,19]
	 * @param max
	 * @return
	 */
	public int[] getPrimes(int max){
		if(max<3){
			return null;
		}
		int[] temp = new int[100];
		int index = 0;
		int i = 2;//最小素数
		while(i<max){
			boolean isPrime = true;
			for(int z = 2;z<i;z++){ //以满足素数的条件进行判断
				if(i%z==0){
					isPrime = false;
					break;
				}
			}
			if(!isPrime){ //非素数跳出本次循环
				i++;
				continue;
			}
			if(index+1>temp.length-1){ //判断空间是否充足，否扩容
				temp = copyAddArray(temp);
			}
			temp[index++] = i;
			i++;
		}
		int[] prime = new int[index];
		System.arraycopy(temp, 0, prime, 0, index);
		return prime;
	}
	
	/**
	 * 所谓“完数”， 是指这个数恰好等于它的因子之和，例如6=1+2+3
	 * 给定一个最大值max， 返回一个数组， 数组中是小于max 的所有完数
	 * @param max
	 * @return
	 */
	public int[] getPerfectNumbers(int max){
		if(max <2){
			return null;
		}
		
		int[] temp = new int[100];
		int index = 0;
		int i = 2;
		while(i<max){
			int sum = 0;
			for(int z=1;z<i;z++){
				if(i%z == 0){
					sum += z;
				}
			}
			if(i != sum){
				i++;
				continue;
			}
			if(index+1>temp.length-1){ //判断空间是否充足，否扩容
				temp = copyAddArray(temp);
			}
			temp[index++] = i;
			i++;
		}
		if(0==index){
			return null;
		}
		int[] perfectNum  = new int[index];
		System.arraycopy(temp, 0, perfectNum, 0, index);
		return perfectNum;
	}
	
	/**
	 * 用seperator 把数组 array给连接起来
	 * 例如array= [3,8,9], seperator = "-"
	 * 则返回值为"3-8-9"
	 * @param array
	 * @param s
	 * @return
	 */
	public String join(int[] array, String seperator){
		StringBuilder stb = new StringBuilder();
		for(int i = 0; i<array.length; i++){
			stb.append(array[i]);
			if(i==array.length-1){
				continue;
			}
			stb.append(seperator);
		}
		return stb.toString();
	}
	

}
