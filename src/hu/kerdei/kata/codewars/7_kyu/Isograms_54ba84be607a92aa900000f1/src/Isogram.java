//https://www.codewars.com/kata/isograms/

import java.util.function.Function;
import java.util.stream.Collectors;

public class Isogram {
    public static boolean isIsogram(String str) {
        return str.toLowerCase()
                .chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .noneMatch(x -> x.getValue() > 1);
    }
}