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
    @Test
    public void testHandleNewLinesBetweenNumbers(){
        assertEquals(6,Calculator.add("1\n2,3"));
    }
    @Test
    public void testAddWithASimpleDelimiter(){
        assertEquals(3,Calculator.add("//;\n1;2"));
    }
    @Test
    public void testAddWithANegativeNumber(){
        try{
            Calculator.add("1,-2");
            fail();
        }catch (RuntimeException re){
            assertEquals("negatives not allowed", re.getMessage());
        }
    }
    @Test
    public void testAddWithManyNegativeNumbers(){
        try {
            Calculator.add("-1,-2");
            fail();
        }catch (RuntimeException re){
            assertEquals("negatives not allowed,-1,-2", re.getMessage());
        }
    }
    @Test
    public void testAddWithNumbersBiggerThanOneThousand(){
        assertEquals(2,Calculator.add("2,1001"));
    }
    @Test
    public void testAddWithAnyLengthDelimiter(){
        assertEquals(6,Calculator.add("//[***]\n1***2***3"));
    }

}
