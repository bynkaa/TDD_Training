package com.qsoft.examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 6/3/13
 * Time: 1:53 PM
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
                return addListStringNumbers(s2.split(Pattern.quote(s1)));
            }
            else {

                String regex2 = "//\\[(.*)\\]\\n(.*)";
                Matcher m2 = Pattern.compile(regex2).matcher(s);
                if (m2.find()){

                    String s1 = m2.group(1);

                    String s2 = m2.group(2);
                    return addListStringNumbers(s2.split(Pattern.quote(s1)));
                }
            }
        }
        else
        {
            return addListStringNumbers(s.split("[,\n]"));

        }
        return -1;

    }

    private static int addListStringNumbers(String[] listNumbers){

        int Sum = 0;
        for (String number : listNumbers){
            int n = Integer.parseInt(number);
            if (n < 0)
                throw new RuntimeException("negatives not allowed!");
            if (n < 1000)
                Sum += Integer.parseInt(number);
        }
        return Sum;
    }
}
