package com.qsoft.tdd;

import java.util.ArrayList;
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
                String[] listStrNumbers = s2.split(Pattern.quote(s1));
                return computeTotalOfListNumbers(listStrNumbers);
            }
            else {
                String regex2 = "//\\[(.*)\\]\n(.*)";
                Matcher m2 = Pattern.compile(regex2).matcher(s);
                if (m2.find()){
                    String s1 = m2.group(1);
                    String s2 = m2.group(2);
                    if (s1.contains("][")){

                        String delimiter = s1.replace("][","");
                        delimiter = "[" + Pattern.quote(delimiter) + "]";

                        String[] listNumbers = s2.split(delimiter);
                        return computeTotalOfListNumbers(listNumbers);

                    }
                    else {
                        String[] listNumbers = s2.split(Pattern.quote(s1));
                        return computeTotalOfListNumbers(listNumbers);
                    }

                }
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
        ArrayList<Integer> negativeNumbersList = new ArrayList<Integer>();
        for (String strNumber : listStrNumbers)
        {
            int number = Integer.parseInt(strNumber);
            if (number < 0){
                negativeNumbersList.add(number);
            }
            else if (number <= 1000)
                sum += number;
        }
        if (!negativeNumbersList.isEmpty()){
            String message = "negatives not allowed";
            if (negativeNumbersList.size() >= 2)
            {
                for (Integer i : negativeNumbersList)
                    message += "," + i.toString();
            }
            throw new RuntimeException(message);


        }
        return sum;
    }
}
