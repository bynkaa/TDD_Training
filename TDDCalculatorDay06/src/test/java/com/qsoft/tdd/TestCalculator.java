package com.qsoft.tdd;

import junit.framework.Assert;
import org.junit.Test;

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
        Assert.assertEquals(0,Calculator.add(""));
    }

}
