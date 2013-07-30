package com.qsoft.tdd;

/**
 * User: BinkaA
 * Date: 7/30/13
 * Time: 11:34 AM
 */
class Node{
    Object data;
    Node next;

    Node(Object data)
    {
        this.data = data;
    }
}

public class SingleLinkedList
{

    private Node first;
    private Node last;
    public SingleLinkedList(){

    }

    public SingleLinkedList(Object[] objects){
        for (int i = 0; i < objects.length; i++)
            append(objects[i]);

    }

    public Node getFirst()
    {
        return first;
    }

    public Node getLast(){
        return last;
    }

    public void append(Object data){
        Node node = new Node(data);
        if (last != null){
            last.next = node;
            last = node;
        }
        else {
            last = node;
            first = last;
        }

    }
    public Node find(Object o){
        Node node = first;
        while(node != null)
        {
            if (node.data == o)
                return node;
            node = node.next;
        }
        return null;
    }

    public int size(){
        int size = 0;
        Node node = first;
        while (node != null){
            size ++;
            node = node.next;
        }
        return size;
    }
    public void insertFirst(Object o){
        Node node = new Node(o);
        if (first == null)
            first = node;
        else {
            node.next = first;
            first = node;
        }

    }

    public void insertAfter(Node n, Object o){
        Node node = new Node(o);
        node.next = n.next;
        n.next = node;
    }


    public void delete(Node node)
    {
        // delete at beginning
        if (first == node){
            Node obsoleteNode = first;
            first = first.next;
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
        for (currentNode = first; currentNode != node; previous = currentNode, currentNode = currentNode.next)
        {

        }
        return previous;
    }

    public Node after(Node node){
        return node.next;
    }

}
