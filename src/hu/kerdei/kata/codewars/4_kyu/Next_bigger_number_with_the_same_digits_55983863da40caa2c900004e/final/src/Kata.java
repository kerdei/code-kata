import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Kata {

    static long nextBiggerNumber(long inputNumber) {
        return isThereBiggerNumberThenInputNumber(inputNumber) ? findBiggerNumber(inputNumber) : -1;
    }

    /**
     *  We increment the input number, until we find the closest number which have the same numerical chars then the input number
     */
    private static long findBiggerNumber(long n) {
        long inputNumber = n;
        n++;
        while (!areTheyHaveTheSameChars(n, inputNumber)) {
            n++;
        }
        return n;
    }

    /**
     * @returns true if we remove each element individually from the other list, we have a empty list.
     */
    private static boolean areTheyHaveTheSameChars(long possibleBiggerNumber, long inputNumber) {
        String[] possibleNumberInList = String.valueOf(possibleBiggerNumber).split("");
        List<String> inputNumberInList = new LinkedList<>(Arrays.asList(String.valueOf(inputNumber).split("")));
        for (String o : possibleNumberInList) {
            inputNumberInList.remove(o);
        }
        return !(inputNumberInList.size() > 0);
    }

    /**
     * @returns true if there is a bigger number then the input number, with the same numbers
     */
    private static boolean isThereBiggerNumberThenInputNumber(long inputNumber) {
        char[] chars = String.valueOf(inputNumber).toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] < chars[i + 1]) {
                return true;
            }
        }
        return false;
    }

}