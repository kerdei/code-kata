import java.security.InvalidParameterException;

public class MostDigits {
    public static int findLongest(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            throw new InvalidParameterException();
        }

        int longestDigit = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (String.valueOf(Math.abs(longestDigit)).length() < String.valueOf(Math.abs(numbers[i])).length()) {
                longestDigit = numbers[i];
            }
        }

        return longestDigit;

    }
}