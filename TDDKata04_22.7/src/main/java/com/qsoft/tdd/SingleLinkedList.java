package com.qsoft.tdd;

import java.util.ArrayList;

/**
 * User: BinkaA
 * Date: 7/22/13
 * Time: 1:39 PM
 */
class Node{
    Object data;
    Node next;
    public Node(Object data){
        this.data = data;
        next = null;
    }

}
public class SingleLinkedList
{
    private Node firstNode;
    private Node lastNode;
    public SingleLinkedList(){
        firstNode = null;
        lastNode = null;
        firstNode = lastNode;
    }
    public SingleLinkedList(Object[] objects){
        for (int i = 0; i < objects.length; i++)
            append(objects[i]);

    }
    public void append(Object data){
        Node node = new Node(data);
        if (lastNode != null){
            lastNode.next = node;
            lastNode = node;
        }
        else {
            lastNode = node;
            firstNode = lastNode;
        }

    }
    //------------------------GET AND SET METHODS-------------------------------------------

    public Node getFirstNode()
    {
        return firstNode;
    }

    public Node getLastNode()
    {
        return lastNode;
    }

//    public void insertFirst(Object o){
//        Node node = new Node(o);
//        node.next = firstNode;
//        firstNode = node;
//    }

}
