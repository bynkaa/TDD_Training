package com.qsoft.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/17/13
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyStack<S> {
    private List<S> listElement = new ArrayList<S>();
    private int size = 0;
    public MyStack(){

    }
    public int size() {
        return listElement.size();  //To change body of created methods use File | Settings | File Templates.
    }

    public void push(S element) {
        listElement.add(element);
        size ++;
        //To change body of created methods use File | Settings | File Templates.
    }

    public S top() {
        if (size == 0)
            return null;
        return listElement.get(size - 1);
    }

    public S pop() {
        if (listElement.isEmpty())
            throw new StackEmptyException();
        size = listElement.size();
        return listElement.remove(size - 1);
    }
}

