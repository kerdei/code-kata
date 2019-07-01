public class Vowels {

    public static int getCount(String str) {
        String vowels = "aeiou";
        return (int) str.chars().filter(c -> vowels.indexOf(c) >= 0).count();
    }
}