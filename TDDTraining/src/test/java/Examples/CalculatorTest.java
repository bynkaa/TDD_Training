package Examples;

import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 5/15/13
 * Time: 11:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class CalculatorTest {
    @Test
    public void testAdd(){

            assertEquals(0,Calculator.Add(""));
            assertEquals(1,Calculator.Add("1"));
            assertEquals(3,Calculator.Add("1,2"));
            assertEquals(15,Calculator.Add("1,2,3,4,5"));
            assertEquals(6,Calculator.Add("1\n2,3"));
            assertEquals(10,Calculator.Add("1\n2\n3\n4"));


    }
    @Test
    public void TestCustomDelimiter(){
            assertEquals(3,Calculator.Add("//;\n1;2"));
            assertEquals(11,Calculator.Add("///\n1/3/7"));
    }
    @Test
    public void TestNegativeException(){
           try{
               Calculator.Add("1,-2");
           }catch (IllegalArgumentException e){
                assertEquals(Calculator.negativeException,e.getMessage());
           }

    }
    @Test
    public void AddWithNumberBiggerThanOneThousand(){

            assertEquals(2,Calculator.Add("2,1001"));

    }
    @Test
    public void checkMultipleDelimiter(){
        assertEquals(6,Calculator.Add("[*][%]\n1*2%3"));
    }
    @Test
    public void AddWithDelimiterOfAnyLength(){
        assertEquals(6,Calculator.Add("//[**]\n1**2**3"));
    }
    @Test
    public void checkPatternMatchRegex(){
        assertTrue(Calculator.checkOneCharCustomDelimiter("//;\n1;2;3"));
        assertFalse(Calculator.checkOneCharCustomDelimiter(";\n1;2"));
        assertFalse(Calculator.checkOneCharCustomDelimiter("//[****]\n1***2***3"));
        assertTrue(Calculator.checkMultipleCustomDelimiter("//[****]\n1***2***3"));
    }




}
