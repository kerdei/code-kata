import java.lang.StringBuilder;

class Solution {

    static String toCamelCase(String s) {
        String[] split = s.split("-");
        if (split.length == 1) {
            split = split[0].split("_");
        }

        for (int i = 1; i < split.length; i++) {
            StringBuilder stringBuilder = new StringBuilder(split[i]);
            stringBuilder.setCharAt(0, Character.toUpperCase(split[i].charAt(0)));
            split[i] = stringBuilder.toString();
        }

        return String.join("", split);

    }
}