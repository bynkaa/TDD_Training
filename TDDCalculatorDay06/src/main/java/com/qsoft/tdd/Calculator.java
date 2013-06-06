package com.qsoft.tdd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        else if (s.contains("//")){
            String regex = "//(.)\n(.*)";
            Matcher m = Pattern.compile(regex).matcher(s);
            if (m.find()){
                String firstSubStringComponent = m.group(1);
                String secondSubStringComponent = m.group(2);
                String[] listStrNumber = secondSubStringComponent.split(firstSubStringComponent);
                return computeTotalOfAListNumbers(listStrNumber);
            }
            return -1;
        }
        else{

            String[] listStrNumber = s.split("[,\n]");
            return computeTotalOfAListNumbers(listStrNumber);

        }

    }
    private static int computeTotalOfAListNumbers(String[] listStrNumber){
        int sum = 0;
        for (String strNumber : listStrNumber)
            sum += Integer.parseInt(strNumber);
        return sum;
    }
}
