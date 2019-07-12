//https://www.codewars.com/kata/credit-card-mask

public class Maskify {
    public static String maskify(String str) {

        int length = str.length();
        if (length <= 4) {
            return str;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < length - 4; i++) {
                stringBuilder.append("#");
            }
            stringBuilder.append(str.substring(length - 4));

            return stringBuilder.toString();
        }
    }
}
