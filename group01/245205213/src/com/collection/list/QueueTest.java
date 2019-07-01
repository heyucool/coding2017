package com.collection.list;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void test() {
        Queue<Integer> queue = new Queue<Integer>();
        System.out.println(queue);
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
            System.out.println(queue);
        }
        System.out.println(queue);
        for (int i = 0; i < 10; i++) {
            queue.deQueue();
            System.out.println(queue);
        }
    }

}
