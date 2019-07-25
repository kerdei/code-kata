import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateEncoder {
    static String encode(String word) {
        Map<Integer, Long> groupCharsByCount = word
                .toLowerCase()
                .chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            if (groupCharsByCount.get((int) Character.toLowerCase(word.charAt(i))) > 1) {
                stringBuilder.append(")");
            } else {
                stringBuilder.append("(");
            }
        }
        return stringBuilder.toString();
    }
}
