//https://www.codewars.com/kata/57a153e872292d7c030009d4

public class Kata {
    public static String simpleTransposition(String text) {
        StringBuilder row1 = new StringBuilder();
        StringBuilder row2 = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (i % 2 == 0) {
                row1.append(text.charAt(i));
            } else {
                row2.append(text.charAt(i));
            }
        }

        return row1.append(row2.toString()).toString();
    }
}