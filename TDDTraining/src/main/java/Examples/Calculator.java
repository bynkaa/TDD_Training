package Examples;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 5/15/13
 * Time: 11:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Calculator {
    public static String negativeException = "negatives not allowed";
    public static Character[] specialChracter = {'*','.','|','+'};
    public static int Add(String s){
        if (s.isEmpty())
            return 0;

        if (checkOneCharCustomDelimiter(s)){

                return addUsingCustomDelimiter(s);
        }
        if (checkMultipleCustomDelimiter(s)){
           return addUsingAnyLengthCustomDelimiter(s);
        }
        else {
                return addUsingDefaultDelimiter(s);
        }

    }
    // using any length custom delimiter
    private static int addUsingAnyLengthCustomDelimiter(String s) {
        int start = 3;
        int finish = s.indexOf("]",3);
        String delimiter = s.substring(start,finish);
        s = s.substring(finish + 2,s.length());
        s = s.replace(delimiter,",");
        return addUsingDefaultDelimiter(s);
    }
    // using simple custom delimiter
    public static int addUsingCustomDelimiter(String s) {
        int linebreakIndex = s.indexOf("\n");

        String customDelimiter = s.substring(2, linebreakIndex);

        s = s.substring(linebreakIndex+1,s.length());
        s = s.replace(customDelimiter,",");
        return addUsingDefaultDelimiter(s);
    }
    // using default delimiter
    public static int addUsingDefaultDelimiter(String s) {
        String[] strList = s.split("[,\n]");
        return  countTotal(strList);
    }
    //
    public static boolean checkOneCharCustomDelimiter(String s){
        String regex = "(//)(.)(\n)([0-9]+(.)*[0-9]+)";
        return s.matches(regex);

    }

    public static boolean checkMultipleCustomDelimiter(String s){
        String pattern = "(//\\[)(.)+(\\]\n)(.)+[0-9]+";
        return s.matches(pattern);
    }


    public static int countTotal(String[] strList){
        int sum = 0;
        for (String str : strList){

            int number = Integer.parseInt(str);
            if (number < 0)
                throw new IllegalArgumentException(negativeException);
            if (number <= 1000)
                sum += Integer.parseInt(str);
        }
        return sum;
    }

}