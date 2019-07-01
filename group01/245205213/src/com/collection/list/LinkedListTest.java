package com.collection.list;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {
    LinkedList<Integer> ll = new LinkedList<Integer>();

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void add() {
        ll.add(2);
        ll.add(2);
        Assert.assertEquals(true, ll.add(1));
        Assert.assertEquals(new Integer(2), ll.getFirst());
        Assert.assertEquals(new Integer(1), ll.getLast());
        Assert.assertEquals(new Integer(2), ll.get(1));
        Assert.assertEquals(new Integer(3), new Integer(ll.size()));
        Assert.assertEquals(new Integer(2), ll.remove(1));
        ll.add(4);
        ll.addFirst(4);
        ll.add(2, 3);
        Assert.assertEquals(new Integer(4), ll.removeFirst());
        System.out.println(ll);
    }

}
