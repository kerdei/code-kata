import java.util.Arrays;
import java.util.Comparator;

public class Order {
    public static String order(String words) {
        Comparator<String> stringComparator = getComparator();
        String[] split = words.split(" ");
        Arrays.sort(split, stringComparator);
        return String.join(" ", split);
    }

    public static Comparator<String> getComparator() {
        return (o1, o2) -> {
            int o1Number = 0;
            for (int i = 0; i < o1.length(); i++) {
                if (Character.isDigit(o1.charAt(i))) {
                    o1Number = Character.getNumericValue(o1.charAt(i));
                }
            }
            int o2Number = 0;
            for (int i = 0; i < o2.length(); i++) {
                if (Character.isDigit(o2.charAt(i))) {
                    o2Number = Character.getNumericValue(o2.charAt(i));
                }
            }
            if (o1Number == o2Number) return 0;
            return o1Number > o2Number ? 1 : -1;
        };
    }
}