import java.util.ArrayList;
import java.util.List;

public class MexicanWave {

    public static String[] wave(String str) {

        List<String> mexicanWavedStringList = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.setCharAt(i, Character.toUpperCase(stringBuilder.charAt(i)));
            if (!stringBuilder.toString().equals(str)) {
                mexicanWavedStringList.add(stringBuilder.toString());
            }
        }

        return mexicanWavedStringList.toArray(new String[0]);
    }

}