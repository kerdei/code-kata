public class Kata {
    public static String reverseWords(final String original) {
        String[] split = original.split(" ");
        for (int i = 0; i < split.length; i++) {
            split[i] = new StringBuilder(split[i]).reverse().toString();
        }
       return String.join(" ", split);
    }
}