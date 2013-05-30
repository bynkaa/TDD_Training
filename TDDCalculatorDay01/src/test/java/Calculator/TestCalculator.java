package Calculator;

import org.junit.Test;
import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 5/30/13
 * Time: 2:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestCalculator {
    @Test
    public void testOneIntStringCalculator(){
        assertEquals(1,Calculator.add("1"));

    }
    @Test
    public void testTwoIntStringCalculator() {
        assertEquals(3,Calculator.add("1,2"));
    }
    @Test
    public void testWithUnknowAmountOfNumber(){
        assertEquals(10,Calculator.add("1,2,3,4"));
    }

    @Test
    public void testAddWithNewLineDelimiter(){
        assertEquals(6,Calculator.add("1\n2,3"));
    }
    @Test
    public void testWithASimpleCustomeDelimiter(){
        assertEquals(3,Calculator.add("//;\n1;2"));
    }


}
