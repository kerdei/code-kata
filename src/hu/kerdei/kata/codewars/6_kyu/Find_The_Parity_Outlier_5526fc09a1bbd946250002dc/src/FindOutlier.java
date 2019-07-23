import java.util.ArrayList;
import java.util.List;

public class FindOutlier {
    static int find(int[] integers) {

        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();

        for (int integer : integers) {
            if (integer % 2 == 0) {
                evenNumbers.add(integer);
            } else {
                oddNumbers.add(integer);
            }
        }

        return oddNumbers.size() == 1 ? oddNumbers.get(0) : evenNumbers.get(0);
    }
}