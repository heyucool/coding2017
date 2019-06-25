import com.collection.list.ArrayList;
import com.collection.list.LinkedList;
import com.collection.list.Queue;
import com.collection.list.Stack;

public class JavaTest {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    //测试ArrayList
//         ArrayList arrList = new ArrayList();
//         for (int i = 0; i < 5; i++) { 
//             arrList.add(i); 
//         } 
//         arrList.add(5, 10);
//         System.out.println("size:" + arrList.size()); 
//         System.out.println("get:" + arrList.get(2)); 
//         System.out.println(arrList); 
//         System.out.println("remove:" + arrList.remove(2)); 
//         System.out.println("remove:" + arrList.remove(5));
//         System.out.println(arrList); 
	    //测试LinkedList
//	    LinkedList linkedList = new LinkedList();
//	    for (int i = 0; i < 20; i++) {
//	        linkedList.add(i);
//        }
//        System.out.println("size:"+ linkedList.size());
//        System.out.println("get:" + linkedList.get(1));
//        System.out.println(linkedList);
//        System.out.println("remove:" + linkedList.remove(1));
//        System.out.println("remove:" + linkedList.remove(15));
//        System.out.println(linkedList);
//        linkedList.addFirst(22);
//        System.out.println("size:"+ linkedList.size());
//        System.out.println(linkedList);
//        System.out.println("removeFirst:"+ linkedList.removeFirst());
//        System.out.println(linkedList);
//        linkedList.add(5, 999);
//        System.out.println(linkedList);
	    //测试Stack
//	    Stack stack = new Stack();
//        System.out.println("isEmpty:" + stack.isEmpty());
//	    for (int i = 0; i < 10; i++) {
//	        stack.push(i);
//        }
//        System.out.println("size:" + stack.size());
//        System.out.println("isEmpty:" + stack.isEmpty());
//	    System.out.println(stack);
//        System.out.println("pop:" + stack.pop());
//        System.out.println("pop:" + stack.pop());
//        System.out.println(stack);
//        System.out.println("peek:" + stack.peek());
//        System.out.println("peek:" + stack.peek());
//        System.out.println(stack);
//        System.out.println("size:" + stack.size());
	    //测试Queue
	    Queue queue = new Queue();
        System.out.println("isEmpty:" + queue.isEmpty());
	    for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }
        System.out.println("isEmpty:" + queue.isEmpty());
        System.out.println("size:" + queue.size());
        System.out.println(queue);
        System.out.println("deQueue:" + queue.deQueue());
        System.out.println(queue);
	    
	}
	
}
