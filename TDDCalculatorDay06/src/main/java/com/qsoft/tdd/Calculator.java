package com.qsoft.tdd;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/6/13
 * Time: 1:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Calculator {
    public static int add(String s) {

        if (s.isEmpty())
            return 0;
        else{
            String[] listStrNumber = s.split("[,\n]");
            int sum = 0;
            for (String strNumber : listStrNumber)
                sum += Integer.parseInt(strNumber);
            return sum;

        }

    }
}
