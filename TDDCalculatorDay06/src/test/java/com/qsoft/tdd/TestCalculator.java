package com.qsoft.tdd;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/6/13
 * Time: 1:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestCalculator {
    @Test
    public void testEmptyString(){
        assertEquals(0, Calculator.add(""));
    }
    @Test
    public void testOneStringNumber(){
        assertEquals(1,Calculator.add("1"));
    }
    @Test
    public void testTwoStringNumbers(){
        assertEquals(3,Calculator.add("1,2"));
    }
    @Test
    public void testAddHandleUnknowAmountOfNumbers(){
        assertEquals(6,Calculator.add("1,2,3"));
    }
    @Test
    public void testAddHandleNewLinesBetweenNumbers(){
        assertEquals(6,Calculator.add("1\n2,3"));
    }
    @Test
    public void testAddWithACustomDelimiter(){
        assertEquals(3,Calculator.add("//;\n1;2"));
    }
    @Test
    public void testAddWithNegativeNumbers(){
        try{
            Calculator.add("1,-1");
            fail();
        }catch (RuntimeException re){
            assertEquals("Negattives not allowed",re.getMessage());
        }
    }



}
