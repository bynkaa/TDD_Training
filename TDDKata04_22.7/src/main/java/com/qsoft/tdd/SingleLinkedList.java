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

}
public class SingleLinkedList
{
    Node firstNode;
    Node lastNode;
    public SingleLinkedList(){
        firstNode = new Node();
        lastNode = new Node();
    }
    public SingleLinkedList(Object[] objects){
        for (int i = 0; i < objects.length; i++)
            append(objects[i]);
    }
    public void append(Object data){
        Node lastNode = new Node();
        lastNode.data = data;
        lastNode.next = null;
    }

    public Node find(Object o){
        if (firstNode == null)
            return null;
        Node node = firstNode;
        do
        {
            if (node.data == o)
                return node;
        }while (node.next != null);
        return null;
    }

//    public void insertAfter(Node node, Object o){
//        Node newNode = new Node();
//        newNode.data = o;
//        if(node != null){
//            newNode.next = node.next;
//            node.next = newNode;
//        }
//    }

}
