package com.collection.list;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayListTest {
    private ArrayList<Integer> al;
    @BeforeEach
    void setUp() throws Exception {
        al = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11));
    }
    @AfterEach
    void tearDown() throws Exception {
        System.out.println(al);
    }

    @Test
    void add() {
        System.out.println("add:***********");
        Assert.assertEquals(true, al.add(2));
    }

    @Test
    void addElement() {
        System.out.println("addElement:***********");
        Assert.assertEquals(true, al.add(1,3));
    }

    @Test
    void get() {
        System.out.println("get:***********");
        Assert.assertEquals(new Integer(1), al.get(0));
    }

    @Test
    void clear() {
        System.out.println("clear:***********");
        Assert.assertEquals(true, al.clear());
    }

    @Test
    void remove() {
        System.out.println("remove:***********");
        Assert.assertEquals(new Integer(2), al.remove(1));
    }

}
