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

}