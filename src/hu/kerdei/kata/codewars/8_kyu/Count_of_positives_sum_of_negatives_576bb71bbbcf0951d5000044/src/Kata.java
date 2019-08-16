import java.util.Arrays;

public class Kata {
    public static int[] countPositivesSumNegatives(int[] input) {
        
        if (input == null || input.length == 0) {
            return new int[]{};
        }

        int positiveCount = 0, negativeSum = 0;
        for (int i : input) {
            if (i >0) {positiveCount++;}
            else negativeSum+=i;
        }

        return new int[]{positiveCount, negativeSum};
    }
}