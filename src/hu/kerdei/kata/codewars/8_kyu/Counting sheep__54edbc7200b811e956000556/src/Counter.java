import java.util.Arrays;
import java.util.Objects;

public class Counter {
    public int countSheeps(Boolean[] arrayOfSheeps) {
        return Arrays.stream(arrayOfSheeps).filter(Objects::nonNull).mapToInt(x -> x ? 1 : 0).sum();
    }
}