public class Solution {

    public static boolean validatePin(String pin) {
        int pinLength = pin.length();
        if (pinLength == 4 || pinLength == 6) {
            return pin.matches("^[0-9]*$");
        }
        return false;
    }
}