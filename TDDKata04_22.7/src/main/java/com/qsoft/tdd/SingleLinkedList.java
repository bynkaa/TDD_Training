package com.qsoft.tdd;

import java.util.ArrayList;

/**
 * User: BinkaA
 * Date: 7/22/13
 * Time: 1:39 PM
 */
public class SingleLinkedList
{
    private ArrayList dataList;

    public SingleLinkedList(){
        dataList = new ArrayList();
    }
    public SingleLinkedList(Object[] arrayObject)
    {
        dataList = new ArrayList();
        for (int i = 0; i < arrayObject.length; i++)
            dataList.add( arrayObject[i]);
    }
    public int find(Object data){
        for (int i = 0; i < dataList.size(); i ++)
        {
            if (dataList.get(i).equals(data))
                return i;
        }
        return -1;
    }
}
