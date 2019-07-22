public class DRoot {
    public static int digital_root(int n) {
        int result = n;

        while (result >= 10) {
            String numberInString = String.valueOf(result);
            result = 0;
            for (int i = 0; i < numberInString.length(); i++) {
                result += Character.getNumericValue(numberInString.charAt(i));
            }
        }

        return result;
    }
}