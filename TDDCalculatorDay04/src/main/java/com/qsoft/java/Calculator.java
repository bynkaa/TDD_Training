package com.qsoft.java;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/4/13
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Calculator {
    public static int add(String s) {

        if (s.isEmpty())
            return 0;
        else {
            String[] listNumbers = s.split("[,\n]");
            int sum  = 0;
            for (String number : listNumbers){
                sum += Integer.parseInt(number);
            }
            return sum;
        }


    }
}
