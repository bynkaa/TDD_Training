package Examples;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;


/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 5/16/13
 * Time: 1:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class EnglishTest {
    @Test
    public void TestNumberZero(){
        assertEquals("zero", English.numberToWords(0));
    }
    @Test
    public void TestNumberOne(){
        assertEquals("one",English.numberToWords(1));
    }
    @Test
    public void TestNumberTwo(){
        assertEquals("two",English.numberToWords(2));
    }
    @Test
    public void TestNumberThree(){
        assertEquals("three",English.numberToWords(3));
    }
    @Test
    public void TestNumberFour(){
        assertEquals("four",English.numberToWords(4));
    }
    @Test
    public void TestNumberFive(){
        assertEquals("five",English.numberToWords(5));
    }
    @Test
    public void TestNumberSix(){
        assertEquals("six",English.numberToWords(6));
    }
    @Test
    public void TestNumberSeven(){
        assertEquals("seven",English.numberToWords(7));
    }
    @Test
    public void TestNumberEight(){
        assertEquals("eight",English.numberToWords(8));
    }
    @Test
    public void TestNumberNine(){
        assertEquals("nine",English.numberToWords(9));
    }
    @Test
    public void TestNumber10(){
        assertEquals("ten",English.numberToWords(10));

    }
    @Test
    public void TestNumber11(){
        assertEquals("eleven",English.numberToWords(11));

    }
    @Test
    public void TestNumber12(){
        assertEquals("twelve",English.numberToWords(12));

    }
    @Test
    public void TestNumber13(){
        assertEquals("thirteen",English.numberToWords(13));

    }
    @Test
    public void TestNumber14(){
        assertEquals("fourteen",English.numberToWords(14));

    }
    @Test
    public void TestNumber15(){
        assertEquals("fifteen",English.numberToWords(15));

    }
    @Test
    public void TestNumber16(){
        assertEquals("sixteen",English.numberToWords(16));

    }
    @Test
    public void TestNumber17(){
        assertEquals("seventeen",English.numberToWords(17));

    }
    @Test
    public void TestNumber18(){
        assertEquals("eighteen",English.numberToWords(18));

    }
    @Test
    public void TestNumber19(){
        assertEquals("nineteen",English.numberToWords(19));

    }
    @Test
    public void TestNumber20(){
        assertEquals("twenty",English.numberToWords(20));

    }
    @Test
    public void TestNumber21(){
        assertEquals("twenty one",English.numberToWords(21));

    }

    @Test
    public void TestNumber32(){
        assertEquals("thirty two", English.numberToWords(32));

    }
    @Test
    public void TestNumber94(){
        assertEquals("ninety four",English.numberToWords(94));
    }

    @Test
    public void TestThreeDigitNumbers(){
        assertEquals("one hundred one", English.numberToWords(101));
        assertEquals("one hundred",English.numberToWords(100));
        assertEquals("nine hundred ninety nine",English.numberToWords(999));
    }
    @Test
    public void TestFourDigitNumbers(){
        assertEquals("one thousand",English.numberToWords(1000));
        assertEquals("one thousand three",English.numberToWords(1003));
        assertEquals("nine thousand nine hundred ninety nine",English.numberToWords(9999));
    }
    @Test
    public void TestFiveDigitNumbers(){
        assertEquals("ten thousand", English.numberToWords(10000));
        assertEquals("ninety nine thousand nine hundred ninety nine",English.numberToWords(99999));
    }

}
