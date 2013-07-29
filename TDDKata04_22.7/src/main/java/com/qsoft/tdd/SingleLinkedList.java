package com.qsoft.tdd;

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
    public void insertFirst(Object o){
        Node node = new Node(o);
        if (firstNode == null)
            firstNode = node;
        else {
            node.next = firstNode;
            firstNode = node;
        }

    }

    public Node find(Object o){
        Node node = firstNode;
        while(node != null)
        {
            if (node.data == o)
                return node;
            node = node.next;
        }
        return null;
    }

    public void insertAfter(Node n, Object o){
        Node node = new Node(o);
        node.next = n.next;
        n.next = node;
    }

    public int size(){
        int size = 0;
        Node node = firstNode;
        while (node != null){
            size ++;
            node = node.next;
        }
        return size;
    }
    public void delete(Node node)
    {
        // delete at beginning
        if (firstNode == node){
            Node obsoleteNode = firstNode;
            firstNode = firstNode.next;
            obsoleteNode = null;
        }
        else {
            Node previous = before(node);
            Node obsoloteNode = node;
            previous.next = node.next;
            obsoloteNode = null;
        }
    }

    public Node before(Node node){
        Node previous = null;
        Node currentNode = null;
        for (currentNode = firstNode; currentNode != node; previous = currentNode, currentNode = currentNode.next)
        {

        }
        return previous;
    }

    public Node after(Node node){
        return node.next;
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



}
