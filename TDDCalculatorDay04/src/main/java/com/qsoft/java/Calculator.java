package com.qsoft.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (s.contains("//")){
            String regex = "//(.)\n(.*)";
            Matcher m = Pattern.compile(regex).matcher(s);
            if (m.find()){
                String fistSubStringComponent = m.group(1);
                String secondSubStringComponent = m.group(2);
                String[] listNumbers = secondSubStringComponent.split(fistSubStringComponent);
                return computeSumFromListOfStringNumbers(listNumbers);

            }
            else {
                String regex2 = "//\\[(.*)\\]\n(.*)";
                Matcher m2 = Pattern.compile(regex2).matcher(s);
                if (m2.find()){
                    String firstSubStringComponent = m2.group(1);
                    String secondSubStringComponent = m2.group(2);
                    String[] listNumbers = secondSubStringComponent.split(Pattern.quote(firstSubStringComponent));
                    return computeSumFromListOfStringNumbers(listNumbers);
                }
            }
            return -1;
        }
        else {
            return computeSumFromListOfStringNumbers(s.split("[,\n]"));

        }

    }
    private static int computeSumFromListOfStringNumbers(String[] listNumbers){

        int sum  = 0;
        for (String strNumber : listNumbers){
            int number  = Integer.parseInt(strNumber);
            if (number < 0)
                throw new RuntimeException("negatives not allowed!");
            if (number <= 1000)
                sum += number;
        }
        return sum;
    }
}
