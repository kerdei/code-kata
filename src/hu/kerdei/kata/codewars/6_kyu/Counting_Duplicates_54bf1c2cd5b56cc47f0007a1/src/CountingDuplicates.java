//https://www.codewars.com/kata/counting-duplicates/

import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        return (int) text.toLowerCase()
                .chars()
                .boxed()
                .collect(groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .count();
    }
}