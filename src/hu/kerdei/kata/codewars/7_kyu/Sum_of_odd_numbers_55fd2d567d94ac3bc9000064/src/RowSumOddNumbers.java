class RowSumOddNumbers {
    public static int rowSumOddNumbers(int n) {
        int result = 0;
        int number = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                number += 2;
                if (i == n) {
                    result += number - 1;
                }
            }
        }
        return result;
    }
}