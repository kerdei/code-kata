//https://www.codewars.com/kata/roboscript-number-1-implement-syntax-highlighting/ TODO retrain
class RoboScript {

    private static final String F_SPAN_STYLE_COLOR = "<span style=\"color: pink\">";
    private static final String L_SPAN_STYLE_COLOR = "<span style=\"color: red\">";
    private static final String R_SPAN_STYLE_COLOR = "<span style=\"color: green\">";
    private static final String DIGIT_SPAN_STYLE_COLOR = "<span style=\"color: orange\">";
    private static final String CLOSE_SPAN = "</span>";

    static String highlight(String code) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            String selectedSpan = getSpanForChar(code, i);

            if (selectedSpan.equals(DIGIT_SPAN_STYLE_COLOR)) {
                i = digitHighlight(code, stringBuilder, i, selectedSpan);
            }
            if (!selectedSpan.equals(DIGIT_SPAN_STYLE_COLOR) && !selectedSpan.equals("")) {
                i = letterHighlight(code, stringBuilder, i, selectedSpan);
            }
            if (selectedSpan.equals("")) {
                stringBuilder.append(code.charAt(i));
            }
        }

        return stringBuilder.toString();
    }

    private static int letterHighlight(String code, StringBuilder stringBuilder, int i, String selectedSpan) {
        int howManySameLetter = howManySameLetter(i, code);
        stringBuilder.append(selectedSpan);
        for (int i1 = 0; i1 < howManySameLetter; i1++) {
            stringBuilder.append(code.charAt(i));
        }
        i += howManySameLetter - 1;
        stringBuilder.append(CLOSE_SPAN);
        return i;
    }

    private static int digitHighlight(String code, StringBuilder stringBuilder, int i, String selectedSpan) {
        int howManyDigits = howManyDigits(i, code);
        stringBuilder.append(selectedSpan);
        for (int i1 = i; i1 < howManyDigits + i; i1++) {
            stringBuilder.append(code.charAt(i1));
        }
        i += howManyDigits - 1;
        stringBuilder.append(CLOSE_SPAN);
        return i;
    }

    private static String getSpanForChar(String code, int i) {
        String selectedSpan = "";
        if (Character.isDigit(code.charAt(i))) {
            selectedSpan = DIGIT_SPAN_STYLE_COLOR;
        } else {
            if (Character.isLetter(code.charAt(i))) {
                switch (code.charAt(i)) {
                    case 'F':
                        selectedSpan = F_SPAN_STYLE_COLOR;
                        break;
                    case 'L':
                        selectedSpan = L_SPAN_STYLE_COLOR;
                        break;
                    case 'R':
                        selectedSpan = R_SPAN_STYLE_COLOR;
                        break;
                }
            }
        }
        return selectedSpan;
    }

    private static int howManySameLetter(int ii, String code) {

        int count = 1;
        for (int i = ii + 1; i < code.length() && isTheSameChar(code, i); i++) {
            count++;
        }
        return count;
    }

    private static int howManyDigits(int ii, String code) {
        int count = 1;
        for (int i = ii + 1; i < code.length() && Character.isDigit(code.charAt(i)); i++) {
            count++;
        }
        return count;
    }

    private static boolean isTheSameChar(String code, int i) {
        return code.charAt(i) == code.charAt(i - 1);
    }

}