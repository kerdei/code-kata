//https://www.codewars.com/kata/58223370aef9fc03fd000071
public class Solution {

    public static final int NON_NUMERIC = -1;

    public static String dashatize(int num) {
        String numInString = removeNonNumerics(String.valueOf(num));
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numInString.length(); i++) {
            if (Character.getNumericValue(numInString.charAt(i)) % 2 == 0) {
                //Even numbers
                stringBuilder.append(numInString.charAt(i));
            } else {
                //Odd numbers
                //Dash before
                if (stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) != '-') {
                    stringBuilder.append("-");
                }

                stringBuilder.append(numInString.charAt(i));

                //Dash after
                if (i != numInString.length() - 1) {
                    stringBuilder.append("-");
                }
            }
        }

        return stringBuilder.toString();
    }

    private static String removeNonNumerics(String numInString) {
        StringBuilder numWithoutNegatives = new StringBuilder();
        for (int i = 0; i < numInString.length(); i++) {
            if (Character.getNumericValue(numInString.charAt(i)) != NON_NUMERIC) {
                numWithoutNegatives.append(numInString.charAt(i));
            }
        }
        return numWithoutNegatives.toString();
    }

}