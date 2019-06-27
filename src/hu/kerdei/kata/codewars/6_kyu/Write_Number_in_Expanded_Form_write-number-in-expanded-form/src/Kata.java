class Kata {
    public static String expandedForm(int input) {

        StringBuilder stringBuilder = new StringBuilder();
        String number = String.valueOf(input);
        for (int i = 0; i < number.length(); i++) {
            int numericValue = Character.getNumericValue(number.charAt(i));
            if (numericValue != 0) {
                if (i != 0) {
                    stringBuilder.append(" + ");
                }
                stringBuilder.append(numericValue);

                for (int j = i + 1; j < number.length(); j++) {
                    stringBuilder.append("0");
                }
            }
        }
        return stringBuilder.toString();
    }
}
