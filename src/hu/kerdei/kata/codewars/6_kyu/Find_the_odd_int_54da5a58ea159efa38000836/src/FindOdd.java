//https://www.codewars.com/kata/find-the-odd-int

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindOdd {
    public static int findIt(int[] a) {

        return Arrays.stream(a).
                boxed().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() % 2 != 0)
                .mapToInt(Map.Entry::getKey)
                .findFirst()
                .getAsInt();
    }
}