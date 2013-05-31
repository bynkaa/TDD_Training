package com.qsoft.tdd;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: binhtv
 * Date: 5/31/13
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestCalculator {
    @Test
    public void testIsEmpty(){
        assertEquals(0, Calculator.add(""));
    }
    @Test
    public void testOneNumberString(){
        assertEquals(1,Calculator.add("1"));

    }
    @Test
    public void testSimpleCommaDelimiter(){
        assertEquals(3,Calculator.add("1,2"));
    }
    @Test
    public void testHanlderNewLineBetweenNumbers(){
        assertEquals(6,Calculator.add("1\n2,3"));
    }
    @Test
    public void testProcessCustomDelimiter(){
        assertEquals(3,Calculator.add("//;\n1;2"));
    }
    @Test
    public void testNegativeNumbers(){
        try{
             Calculator.add("1,-2");
            fail();
        }catch (RuntimeException re){
            assertEquals("negatives not allowed!",re.getMessage());
        }
    }
    @Test
    public void testWithNumberBiggerThan1000(){
        assertEquals(2,Calculator.add("2,1001"));
    }
    @Test
    public void testADelimiterWithAnyLength(){
        assertEquals(6,Calculator.add("//[***]\n1***2***3"));
    }
    @Test
    public void testWithMultipleDelimiter(){
       assertEquals(6,Calculator.add("//[*][%]\n1*2%3"));
    }
}
