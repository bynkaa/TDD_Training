package com.qsoft.java;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/4/13
 * Time: 1:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestCalculator {
    @Test
    public void testEmptyString(){
       assertEquals(0, Calculator.add(""));
    }
    @Test
    public void testSingerNumber(){
        assertEquals(1,Calculator.add("1"));
    }
    @Test
    public void testSimpleCommaDelimiter(){
        assertEquals(3,Calculator.add("1,2"));
    }
    @Test
    public void testHandleUnknownAmountOfNumbers(){
        assertEquals(6,Calculator.add("1,2,3"));
    }
    @Test
    public void testHandleNewLinesBetweenNumbers(){
        assertEquals(6,Calculator.add("1\n2,3"));
    }

}
