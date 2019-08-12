import java.util.ArrayList;
import java.util.List;

public class Line {
    public static String WhoIsNext(String[] names, int n) {
        List<String> namesq = new ArrayList<>(List.of(names));
        for (int i = 1; i < n; i++) {
            namesq.add(namesq.get(0));
            namesq.add(namesq.get(0));
            namesq.remove(0);
        }
        return namesq.get(0);
    }
}