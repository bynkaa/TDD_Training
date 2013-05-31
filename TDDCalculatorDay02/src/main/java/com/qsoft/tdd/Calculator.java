package com.qsoft.tdd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: binhtv
 * Date: 5/31/13
 * Time: 1:49 PM
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
                String s1 = m.group(1);
                String s2 = m.group(2);
               return calculatorNumbers(s2.split(Pattern.quote(s1)));
            }
            else{
                return addHasComplexDelimiter(s);
            }

        }
        else{
            return calculatorNumbers(s.split("[,\n]"));
        }
    }
    public static int addHasComplexDelimiter(String s){
        String regex = "//\\[(.*)\\]\n(.*)";
        Matcher m = Pattern.compile(regex).matcher(s);
        if (m.find()){
            String s1 = m.group(1);
            if (s1.contains("]["))
            {
               s1 = s1.replace("]["," ");
               String[] delimiters = s1.split(" ");

            }
            String s2 = m.group(2);
            return calculatorNumbers(s2.split(Pattern.quote(s1)));
        }
        return -1;
    }

    public static int calculatorNumbers(String[] listStr ){

        int sum = 0;
        for (String str : listStr)
        {
            int i = Integer.parseInt(str);
            if (i < 0)
                throw new RuntimeException("negatives not allowed!");
            if (i <=  1000)
                sum += i;
        }

        return sum;
    }
}
