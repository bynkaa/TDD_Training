package com.qsoft.tdd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/5/13
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Calculator {
    public static int add(String s) {
        if (s.isEmpty())
            return 0;
        else if (s.startsWith("//")){
            String regex = "//(.)\n(.*)";
            Matcher m = Pattern.compile(regex).matcher(s);
            if (m.find()){
                String s1 = m.group(1);
                String s2 = m.group(2);
                String[] listStrNumbers = s2.split(s1);
                return computeTotalOfListNumbers(listStrNumbers);
            }
            return -1;
        }
        else{
            String[] listStrNumbers = s.split("[,\n]");
            return computeTotalOfListNumbers(listStrNumbers);
        }


    }

    private static int computeTotalOfListNumbers(String[] listStrNumbers){
        int sum = 0;
        for (String strNumber : listStrNumbers)
        {
            sum += Integer.parseInt(strNumber);
        }
        return sum;
    }
}
