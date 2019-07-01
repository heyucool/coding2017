package com.collection.list;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

    static Stack<Integer> stack = new Stack<Integer>();
    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void test() {
        Assert.assertEquals(1, (int)stack.push(1));
        Assert.assertEquals(1, (int)stack.peek());
        System.out.println(stack);
        Assert.assertEquals(1, (int)stack.pop());
        System.out.println(stack);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        System.out.println(stack);
    }

    @Test
    void test2() {
        try {
            Thread t = new Thread(new Runnable() {            
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        stack.pop();
                        System.out.println(stack);
                    }
                }
            });
            while (true) {
                t.start();
            }            
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            System.out.println(stack.size());
            Assert.assertEquals(true, stack.isEmpty());            
        }
    }

}
