public class Kata {

    public static String high(String s) {

        String[] strings = s.split(" ");
        int maxCount = 0;
        String resultWord = "";

        for (String string : strings) {
            int sum = string.chars().map(c -> c - 96).sum();
            if (sum > maxCount) {
                resultWord = string;
                maxCount = sum;
            }
        }

        return resultWord;
    }

}