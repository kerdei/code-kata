public class Kata {
    public static boolean solution(String str, String ending) {
        int originalStringLength = str.length();
        int possibleStringEndingLength = ending.length();

        if (originalStringLength >= possibleStringEndingLength) {
            return str.substring(originalStringLength - possibleStringEndingLength).equals(ending);
        }
        return false;
    }
}