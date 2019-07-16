//https://www.codewars.com/kata/find-the-smallest-integer-in-the-array/

import java.util.Arrays;
import java.util.OptionalInt;

public class SmallestIntegerFinder {
    public static int findSmallestInt(int[] args) {
        return Arrays.stream(args).min().getAsInt();
    }
}