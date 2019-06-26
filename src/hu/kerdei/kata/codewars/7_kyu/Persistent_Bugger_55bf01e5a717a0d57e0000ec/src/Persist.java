class Persist {
    public static int persistence(long n) {
        int multiplicativePersistenceCount = 0;

        String numberInString = String.valueOf(n);
        while (numberInString.length() > 1) {
            int newNumber = Character.getNumericValue(numberInString.charAt(0));

            for (int i = 1; i < numberInString.length(); i++) {
                newNumber *= Character.getNumericValue(numberInString.charAt(i));
            }
            numberInString = String.valueOf(newNumber);
            multiplicativePersistenceCount++;
        }
        return multiplicativePersistenceCount;
    }
}
