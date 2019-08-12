public class Scramblies {

    public static boolean scramble(String str1, String str2) {
        StringBuilder stringBuilder = new StringBuilder(str1);
        for (int i = 0; i < str2.length(); i++) {
            String s = String.valueOf(str2.charAt(i));
            if (stringBuilder.toString().contains(s)) {
                stringBuilder.deleteCharAt(stringBuilder.indexOf(s));
            } else {
                return false;
            }
        }
        return true;
    }
}