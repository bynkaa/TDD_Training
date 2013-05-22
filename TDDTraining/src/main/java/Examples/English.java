package Examples;

/**
 * Created with IntelliJ IDEA.
 * User: BinkaA
 * Date: 5/16/13
 * Time: 1:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class English {
    public static String numberToWords(int i) {
        if ( 0 <= i && i < 10 )
            return oneDigit(i);
        else if (10 <= i && i < 100){
            return twoDigit(i);

        }
        // one hundred -> nine hundred ninety nine
        else if (i >= 100 && i < 1000)
            return moreThanTwoDigits(i,"hundred",100);
        // one thousand -> nine hundred ninety nine thousand nine hundred ninety nine
        else if (i >= 1000 && i < 1000000)
            return moreThanTwoDigits(i,"thousand",1000);
        else if (i >= 1000000 && i < 1000000000)
            return moreThanTwoDigits(i,"million",1000000);
        else
            return "too large number";
    }




    private static String oneDigit(int i){
        switch (i){
            case 0: return "zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
        }
        return "null";
    }

    private static String twoDigit(int i){
        if ( i >= 10 && i <= 20){
            switch (i){
                case 10: return "ten";
                case 11: return "eleven";
                case 12: return "twelve";
                case 13: return "thirteen";
                case 14: return "fourteen";
                case 15: return "fifteen";
                case 16: return "sixteen";
                case 17: return "seventeen";
                case 18: return "eighteen";
                case 19: return "nineteen";
                case 20: return "twenty";
            }
        }
        else {
            int n = i/10;
            String strNumber = "";
            switch (n){
                case 2:
                    strNumber = "twenty";
                    break;
                case 3:
                    strNumber = "thirty";
                    break;
                case 4:
                    strNumber = "forty";
                    break;
                case 5:
                    strNumber = "fifty";
                    break;
                case 6:
                    strNumber = "sixty";
                    break;
                case 7:
                    strNumber = "seventy";
                    break;
                case 8:
                    strNumber = "eighty";
                    break;
                case 9:
                    strNumber = "ninety";
                    break;

            }

            return strNumber + " " + oneDigit(i%10);

        }

        return "null";
    }

    private static String moreThanTwoDigits(int number, String nameOfFistComponent, int numberDigitsSecondComponent){
        String s = nameOfFistComponent;
        int firstComponent = number/numberDigitsSecondComponent;
        int secondComponent = number%numberDigitsSecondComponent;
        String numberName = numberToWords(firstComponent) + " " + s;
        if (secondComponent == 0)
            return numberName;
        numberName = numberName + " " + numberToWords(secondComponent);
        return numberName;
    }
}
