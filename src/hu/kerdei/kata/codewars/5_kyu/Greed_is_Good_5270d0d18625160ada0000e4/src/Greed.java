import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Greed {

    private static final int THREE_1_SCORE = 1000;
    private static final int ONE_1_SCORE = 100;
    private static final int ONE_5_SCORE = 50;
    private static final int GENERAL_SCORE_MULTIPLIER = 100;

    public static int greedy(int[] dice) {

        if (dice == null || dice.length == 0) {
            throw new InvalidParameterException();
        }

        List<Integer> integerList = Arrays.stream(dice).boxed().collect(Collectors.toList());
        int score = 0;
        //Unique 1's triplet check
        if (isThereThisMuch(integerList, 3, 1)) {
            removeThisMuch(integerList, 3, 1);
            score += THREE_1_SCORE;
        }

        //Triplet checks
        for (int i = 2; i <= 6; i++) {
            if (isThereThisMuch(integerList, 3, i)) {
                removeThisMuch(integerList, 3, i);
                score += i * GENERAL_SCORE_MULTIPLIER;
            }
        }

        //1's one's check
        for (int i = 0; i < 2; i++) {
            if (isThereThisMuch(integerList, 1, 1)) {
                score += ONE_1_SCORE;
                removeThisMuch(integerList, 1, 1);
            }
        }
        //5's one's check
        for (int i = 0; i < 2; i++) {
            if (isThereThisMuch(integerList, 1, 5)) {
                score += ONE_5_SCORE;
                removeThisMuch(integerList, 1, 5);
            }
        }

        return score;
    }

    private static void removeThisMuch(List<Integer> integerList, int n, int number) {
        for (int i = 0; i < n; i++) {
            integerList.remove(Integer.valueOf(number));
        }
    }

    private static boolean isThereThisMuch(List<Integer> integerList, int n, int number) {
        long count = integerList.stream().filter(x -> x == number).count();
        return count >= n;
    }

}