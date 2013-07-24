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
    public void testGetFirstNode(){
        String[] arrayObject = {"a"};
        SingleLinkedList singleLinkedList = new SingleLinkedList(arrayObject);
        Node firstNode = singleLinkedList.getFirstNode();
        assertEquals("a",firstNode.data);
        assertEquals(null,firstNode.next);
    }
    @Test
    public void testGetLastNode(){
        String[] arrayObject = {"a","b"};
        SingleLinkedList singleLinkedList = new SingleLinkedList(arrayObject);
        Node lastNode = singleLinkedList.getLastNode();
        assertEquals("b",lastNode.data);
        assertEquals(null,lastNode.next);
    }
    @Test
    public void testAppendData(){

        String[] arrayObject = {"a","b"};
        SingleLinkedList singleLinkedList = new SingleLinkedList(arrayObject);
        singleLinkedList.append("c");
        Node lastNode = singleLinkedList.getLastNode();
        assertEquals("c",lastNode.data);
        assertEquals(null,lastNode.next);

    }

//    @Test
//    public void testFindNotExistedObject(){
//        String[] arrayObject = {"a","b"};
//        SingleLinkedList singleLinkedList = new SingleLinkedList(arrayObject);
//        assertEquals(null,singleLinkedList.find("c"));
//    }
//    @Test
//    public void testAppendAnObject(){
//        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.append("a");
//    }


}
