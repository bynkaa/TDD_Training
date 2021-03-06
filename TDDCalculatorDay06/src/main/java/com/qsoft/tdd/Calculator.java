package com.qsoft.tdd;

import java.util.ArrayList;
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
                String[] listStrNumber = secondSubStringComponent.split(Pattern.quote(firstSubStringComponent));
                return computeTotalOfAListNumbers(listStrNumber);
            }
            else {
                String regex2 = "//\\[(.*)\\]\n(.*)";
                Matcher m2 = Pattern.compile(regex2).matcher(s);
                if (m2.find()){
                    String firstSubStringComponent = m2.group(1);
                    String secondSubStringComponent = m2.group(2);
                    if (firstSubStringComponent.contains("][")){
                        String[] listDelimiters = firstSubStringComponent.split(Pattern.quote("]["));
                        String delimiter = Pattern.quote(listDelimiters[0]);
                        for (int  i = 1; i < listDelimiters.length; i++)
                            delimiter = delimiter + "|" + Pattern.quote(listDelimiters[i]);
                        String[] listStrNumber = secondSubStringComponent.split(delimiter);
                        return computeTotalOfAListNumbers(listStrNumber);
                    }
                    else {
                        String[] listStrNumber = secondSubStringComponent.split(Pattern.quote(firstSubStringComponent));
                        return computeTotalOfAListNumbers(listStrNumber);
                    }
                }

            }
            return -1;
        }
        else{

            String[] listStrNumber = s.split("[,\n]");
            return computeTotalOfAListNumbers(listStrNumber);

        }

    }

    private static int computeTotalOfNumbersKnownFormat(String s, String regex){
        Matcher m = Pattern.compile(regex).matcher(s);
        if (m.find()){
            String firstSubStringComponent = m.group(1);
            String secondSubStringComponent = m.group(2);
            String[] listStrNumber = secondSubStringComponent.split(firstSubStringComponent);
            return computeTotalOfAListNumbers(listStrNumber);
        }
        return -1;
    }
    private static int computeTotalOfAListNumbers(String[] listStrNumber){
        int sum = 0;
        ArrayList<Integer> listNegativeNumbers = new ArrayList<Integer>();
        for (String strNumber : listStrNumber){
            int number = Integer.parseInt(strNumber);
            if (number < 0)
                listNegativeNumbers.add(number);
            else if (number < 1000)
                sum += number;

        }
        if (!listNegativeNumbers.isEmpty()){
            String message = "negatives not allowed";
            if (listNegativeNumbers.size() > 1){
                message = message + " " + listNegativeNumbers.get(0);
                for (int i = 1; i < listNegativeNumbers.size(); i++)
                    message = message + ", " + listNegativeNumbers.get(i);
            }
            throw new RuntimeException(message);
        }


        return sum;
    }
}
