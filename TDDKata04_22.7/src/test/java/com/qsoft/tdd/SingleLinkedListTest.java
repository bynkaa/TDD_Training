package com.qsoft.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: BinkaA
 * Date: 7/22/13
 * Time: 1:39 PM
 */
public class SingleLinkedListTest
{
    @Test
    public void testFindExistedObject(){
        String[] arrayObject = {"a","b"};
        SingleLinkedList singleLinkedList = new SingleLinkedList(arrayObject);
        assertEquals(0, singleLinkedList.find("a"));
    }
    @Test
    public void testFindNotExistedObject(){
        String[] arrayObject = {"a","b"};
        SingleLinkedList singleLinkedList = new SingleLinkedList(arrayObject);
        assertEquals(-1,singleLinkedList.find("c"));
    }
    @Test
    public void testAppendAnObject(){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.append("a");
        assertEquals(0,singleLinkedList.find("a"));
    }
    @Test
    public void testGetSizeOfLinkedList(){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.append("a");
        singleLinkedList.append("b");
        assertEquals(2,singleLinkedList.size());
    }

}
