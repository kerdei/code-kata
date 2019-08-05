//https://www.codewars.com/kata/52742f58faf5485cae000b9a

import java.util.ArrayList;
import java.util.List;

class TimeFormatter {


    static String formatDuration(int remainingSeconds) {
        if (remainingSeconds == 0) {
            return "now";
        }

        List<String> timeList = new ArrayList<>();

        remainingSeconds = addFormattedTimeUnitToList(remainingSeconds, timeList, "year", 31536000);
        remainingSeconds = addFormattedTimeUnitToList(remainingSeconds, timeList, "day", 86400);
        remainingSeconds = addFormattedTimeUnitToList(remainingSeconds, timeList, "hour", 3600);
        remainingSeconds = addFormattedTimeUnitToList(remainingSeconds, timeList, "minute", 60);

        if (remainingSeconds < 60 && remainingSeconds > 0) {
            String second__formatted = remainingSeconds > 1 ? remainingSeconds + " seconds" : "1 second";
            timeList.add(second__formatted);
        }

        return getResultFromFormattedTimeUnits(timeList);


    }

    private static String getResultFromFormattedTimeUnits(List<String> timeUnitList) {
        if (timeUnitList.size() >= 3) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < timeUnitList.size() - 1; i++) {
                stringBuilder.append(timeUnitList.get(i)).append(", ");
            }
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length())
                    .append(" and ")
                    .append(timeUnitList.get(timeUnitList.size() - 1));
            return stringBuilder.toString();
        }

        if (timeUnitList.size() == 2) {
            return timeUnitList.get(0) + " and " + timeUnitList.get(1);
        }
        return timeUnitList.get(0);
    }

    private static int addFormattedTimeUnitToList(int inputSeconds, List<String> list, String timeUnitName, int shiftNumber) {
        if (inputSeconds >= shiftNumber) {
            int days = inputSeconds / shiftNumber;
            String formattedTimeUnit = days > 1 ? days + " " + timeUnitName + "s" : 1 + " " + timeUnitName;
            list.add(formattedTimeUnit);
            inputSeconds -= shiftNumber * days;
        }
        return inputSeconds;
    }

}