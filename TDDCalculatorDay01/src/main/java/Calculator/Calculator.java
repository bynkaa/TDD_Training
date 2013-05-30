package Calculator;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 5/30/13
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Calculator {
    public static int add(String s) {
        if (checkPattern(s)){
            return calculatorWithASimpleCustomDelimiter(s);

        }
        String[] listStrInt = s.split("[,\n]");
        return calculatorListString(listStrInt);
    }


    public static int calculatorWithASimpleCustomDelimiter(String s){
        int start = 2;
        int finish = s.indexOf("\n");
        String delimiter = s.substring(start,finish);
        System.out.println(delimiter);
        String newStr = s.substring(finish+1,s.length());
        return calculatorGivenDelimiter(newStr, delimiter);
    }

    public static int calculatorGivenDelimiter(String s, String Delimiter){
        String[] listStr = s.split(Delimiter);
        return calculatorListString(listStr);
    }

    public static int calculatorListString(String[] listStr){
        int sum = 0;
        for (String s : listStr){
            sum += Integer.parseInt(s);
        }
        return sum;
    }
    public static boolean checkPattern(String s){
        String regex = "//(.)+\n[0-9](.)+[0-9]";
        return s.matches(regex);
    }
}
