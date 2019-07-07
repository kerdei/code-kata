//https://www.codewars.com/kata/55c6126177c9441a570000cc/train/java

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WeightSort {

    public static String orderWeight(String strng) {
        Comparator<String> weightComparator = getWeightComparator();
        List<String> stringList = Arrays.asList(strng.split(" "));
        stringList.sort(weightComparator);
        return String.join(" ", stringList);
    }

    private static Comparator<String> getWeightComparator() {
        return (weight1, weight2) -> {
            int weight1Sum = weight1.chars().map(Character::getNumericValue).sum();
            int weight2Sum = weight2.chars().map(Character::getNumericValue).sum();

            if (weight1Sum == weight2Sum) {
                return weight1.compareTo(weight2);
            }

            return weight1Sum > weight2Sum ? 1 : -1;
        };
    }
}