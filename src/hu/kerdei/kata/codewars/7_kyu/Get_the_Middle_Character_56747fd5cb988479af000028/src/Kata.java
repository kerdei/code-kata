class Kata {
    public static String getMiddle(String word) {
        if (word.length() % 2 != 0) {
            return String.valueOf(word.charAt((word.length() - 1) / 2));
        } else {
            return String.valueOf(word.charAt(((word.length() - 1) / 2))) + word.charAt(((word.length() - 1) / 2) + 1);
        }
    }
}