package com.qsoft.examples;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/3/13
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestCalculator {
    @Test
    public void testEmptyString(){
        assertEquals(0,Calculator.add(""));
    }
    @Test
    public void testAddWithOneNumber(){
        assertEquals(1,Calculator.add("1"));
    }
    @Test
    public void testAddWithSimpleCommaDelimiter(){
        assertEquals(3,Calculator.add("1,2"));
    }
    @Test
    public void testAddMethodHandleNewLinesBetweenNumbers(){
        assertEquals(6,Calculator.add("1\n2,3"));
    }
    @Test
    public void testWithSimpleCustomDelimiter(){
        assertEquals(3,Calculator.add("//;\n1;2"));
    }
    @Test
    public void testNegativeNumbers(){
        try {
            Calculator.add("1,-2");
            fail();
        }catch (RuntimeException re){
            assertEquals("negatives not allowed!",re.getMessage());
        }
    }
    @Test
    public void testNumbersBiggerThan1000(){
        assertEquals(2,Calculator.add("2,1001"));
    }
    @Test
    public void testAnyLengthDelimiter(){
        assertEquals(6,Calculator.add("//[***]\n1***2***3"));
    }
    @Test
    public void testMultipleAnyLengthDelimiter(){
        assertEquals(6,Calculator.add("//[*][%]\n1*2%3"));
    }
}
