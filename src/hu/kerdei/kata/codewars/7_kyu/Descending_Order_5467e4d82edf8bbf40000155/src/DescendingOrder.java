//https://www.codewars.com/kata/descending-order

import java.util.Comparator;
import java.util.stream.Collectors;

public class DescendingOrder {
    public static int sortDesc(final int num) {
        return Integer.valueOf(String.valueOf(num).chars()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .map(Character::getNumericValue)
                .map(String::valueOf)
                .collect(Collectors.joining()));
    }
}