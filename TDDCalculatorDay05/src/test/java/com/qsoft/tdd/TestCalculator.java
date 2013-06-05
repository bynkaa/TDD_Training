package com.qsoft.tdd;

import junit.framework.Assert;
import org.junit.Test;
import static junit.framework.Assert.*;
/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/5/13
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestCalculator {
    @Test
    public void testEmptyString(){
        assertEquals(0,Calculator.add(""));
    }
    @Test
    public void testWithOneNumber(){
        assertEquals(1,Calculator.add("1"));
    }
    @Test
    public void testWithManyNumbers(){
        assertEquals(3,Calculator.add("1,2"));
    }
    @Test
    public void testHandleUnknowAmountOfNumbers(){
        assertEquals(6,Calculator.add("1,2,3"));
    }

}
