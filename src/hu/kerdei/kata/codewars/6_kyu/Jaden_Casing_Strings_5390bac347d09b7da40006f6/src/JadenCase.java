public class JadenCase {

    public String toJadenCase(String phrase) {
        if (phrase == null || phrase.length() == 0) {
            return null;
        }
        String[] split = phrase.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : split) {
            stringBuilder.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).append(" ");
        }

        return stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1);
    }
}