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
        else if (i >= 100 && i < 1000)
            return threeDigits(i);
        else if (i >= 1000 && i < 10000)
            return fourDigits(i);
        else if (i >= 10000 && i <100000)
            return "";
        return "null";
    }


    private static String fourDigits(int i) {
        String s = "thousand";
        int soHangNghin = i/1000;
        int threeDigit = i%1000;
        String numberName = oneDigit(soHangNghin) + " " + s;
        if (threeDigit == 0)
            return numberName;
        numberName = numberName + " " + numberToWords(threeDigit);
        return numberName;
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

    private static String threeDigits(int i){
        String s = "hundred";
        int tram = i / 100;
        i = i%100;
        String numberName = "";
        numberName = oneDigit(tram) + " " + s;
        if (i == 0)
            return numberName;
        numberName = numberName + " " + numberToWords(i);
        return numberName;
    }

}
