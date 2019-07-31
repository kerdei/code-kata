//https://www.codewars.com/kata/human-readable-time/

import java.time.LocalDateTime;

public class HumanReadableTime {
    public static String makeReadable(int int_seconds) {
        String hours_formatted = "00";
        String minutes__formatted = "00";
        String second__formatted = "00";

        if (int_seconds >= 3600) {
            int hours = int_seconds / 3600;
            hours_formatted = hours < 10 ? "0" + hours : String.valueOf(hours);
            int_seconds -= 3600 * hours;
        }

        if (int_seconds >= 60) {
            int minutes = int_seconds / 60;
            minutes__formatted = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
            int_seconds -= 60 * minutes;
        }

        if (int_seconds < 60) {
            second__formatted = int_seconds < 10 ? "0" + int_seconds : String.valueOf(int_seconds);
        }

        return hours_formatted + ":" + minutes__formatted + ":" + second__formatted;
    }

}