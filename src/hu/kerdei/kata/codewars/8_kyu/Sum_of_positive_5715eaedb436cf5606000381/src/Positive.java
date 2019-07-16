//https://www.codewars.com/kata/sum-of-positive/

import java.util.Arrays;

public class Positive {
    public static int sum(int[] arr) {
        return Arrays.stream(arr).filter(x -> x > 0).sum();
    }
}