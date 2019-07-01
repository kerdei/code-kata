public class Troll {
    public static String disemvowel(String str) {
        String vowels = "aeoui";
        return str.chars().filter(c -> vowels.indexOf(Character.toLowerCase(c)) == -1).collect(
                StringBuilder::new,
                StringBuilder::appendCodePoint,
                StringBuilder::append
        ).toString();
    }
}