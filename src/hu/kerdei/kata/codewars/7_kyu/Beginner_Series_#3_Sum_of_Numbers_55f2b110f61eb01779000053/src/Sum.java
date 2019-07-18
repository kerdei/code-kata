public class Sum {
    public int GetSum(int a, int b) {
        return a > b ? sum(a, b) : sum(b, a);
    }

    private int sum(int a, int b) {
        int sum = 0;
        for (int i = b; i <= a; i++) {
            sum += i;
        }
        return sum;
    }
}