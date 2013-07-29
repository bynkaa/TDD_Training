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
    @Test
    public void testInsertFirst(){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.append("a");
        singleLinkedList.insertFirst("b");
        assertEquals("b",singleLinkedList.getFirstNode().data);
    }
    @Test
    public void testFindNotExistedObject(){
        String[] objects = {"a","b"};
        SingleLinkedList singleLinkedList = new SingleLinkedList(objects);
        assertEquals(null,singleLinkedList.find("c"));
    }

    @Test
    public void testFindExistedObject(){
        String[] objects = {"a", "b"};
        SingleLinkedList singleLinkedList = new SingleLinkedList(objects);
        Node foundNode = singleLinkedList.find("b");
        assertEquals("b",foundNode.data);
        assertEquals(null,foundNode.next);
    }
    @Test
    public void testGetSizeOfLinkedList(){
        String[] objects = {"a","b","c"};
        SingleLinkedList singleLinkedList = new SingleLinkedList(objects);
        assertEquals(3,singleLinkedList.size());
    }
    @Test
    public void testInsertAfterNode(){
        String[] objects = {"a", "b", "c"};
        SingleLinkedList singleLinkedList = new SingleLinkedList(objects);
        Node node = singleLinkedList.find("b");
        singleLinkedList.insertAfter(node,"d");
        Node insertedNode = singleLinkedList.find("d");
        assertEquals("d",insertedNode.data);
        Node lastNode = singleLinkedList.getLastNode();
        assertEquals(lastNode,insertedNode.next);
    }
    @Test
    public void testGetPreviousNode(){
        String[] objects = {"a", "b", "c"};
        SingleLinkedList singleLinkedList = new SingleLinkedList(objects);
        Node lastNode = singleLinkedList.getLastNode();
        Node previousNode = singleLinkedList.before(lastNode);
        assertEquals("b",previousNode.data);
    }
    @Test
    public void testDeleteAtBeginning(){
        String[] objects = {"a", "b", "c"};
        SingleLinkedList singleLinkedList = new SingleLinkedList(objects);
        Node firstNode = singleLinkedList.getFirstNode();
        singleLinkedList.delete(firstNode);
        Node newFirstNode = singleLinkedList.getFirstNode();
        assertEquals("b",newFirstNode.data);
    }
    @Test
    public void testDeleteAtMiddle(){
        String[] objects = {"a", "b", "c"};
        SingleLinkedList singleLinkedList = new SingleLinkedList(objects);
        Node middleNode = singleLinkedList.find("b");
        singleLinkedList.delete(middleNode);
        Node newMiddleNode = singleLinkedList.find("b");
        assertEquals(null,newMiddleNode);

    }
    @Test
    public void testGetAfterNode(){
        String[] objects = {"a", "b", "c"};
        SingleLinkedList singleLinkedList = new SingleLinkedList(objects);
        Node node = singleLinkedList.find("b");
        Node afterNode = singleLinkedList.after(node);
        assertEquals("c",afterNode.data);
    }

}
