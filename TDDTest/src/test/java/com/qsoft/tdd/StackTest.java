package com.qsoft.tdd;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/17/13
 * Time: 1:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class StackTest {
    @Test
    public void testCreateNewStack(){
        MyStack<String> myStack = new MyStack<String>();
        assertEquals(0,myStack.size());
    }
    @Test
    public void testPushMethod(){
        MyStack<String> myStack = new MyStack<String>();
        myStack.push("a");
        assertEquals(1,myStack.size());
    }
    @Test
    public void testPushKElement(){
        MyStack<String> myStack = new MyStack<String>();
        myStack.push("a");
        myStack.push("b");
        myStack.push("c");
        assertEquals(3,myStack.size());
    }
    @Test
    public void testTopMethodWithAEmptyStack(){
        MyStack<String> myStack = new MyStack<String>();
        assertEquals(null,myStack.top());
    }
    @Test
    public void testTopMethodWithStackNotNull(){
        MyStack<String> myStack = new MyStack<String>();
        myStack.push("a");
        assertEquals("a",myStack.top());
    }
    @Test
    public void testPopMethodWithEmptyStack(){
        try{
            MyStack<String> myStack = new MyStack<String>();
            String a = myStack.pop();
            fail();
        }catch (StackEmptyException re){
            re.getStackTrace();
        }
    }
    @Test
    public void testPopMethodWithStackNotNull(){
        MyStack<String> myStack = new MyStack<String>();
        myStack.push("a");
        myStack.push("b");
        myStack.pop();
        assertEquals(1, myStack.size());
    }
    @Test
    public void testPopMethodWithStackHasOnlyOneElement(){
        MyStack<String> myStack = new MyStack<String>();
        myStack.push("a");
        myStack.pop();
        assertEquals(0, myStack.size());
    }
    @Test
    public void testTopAndPopMethod(){
        MyStack<String> myStack = new MyStack<String>();
        myStack.push("a");
        myStack.push("b");
        assertEquals("b",myStack.top());
        assertEquals("b",myStack.pop());
    }
    @Test
    public void testPopMethod(){
        MyStack<String> myStack = new MyStack<String>();
        myStack.push("a");
        myStack.push("b");
        myStack.push("c");
        assertEquals("c",myStack.pop());
        assertEquals("b",myStack.pop());
        assertEquals("a",myStack.pop());
    }


}
