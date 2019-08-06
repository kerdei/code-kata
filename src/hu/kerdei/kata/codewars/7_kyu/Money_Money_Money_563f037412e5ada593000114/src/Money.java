public class Money {
    public static int calculateYears(double principal, double interest, double tax, double desired) {
        int count = 0;
        double currentAmount = principal;
        while (currentAmount < desired) {
            double v = currentAmount * interest;
            currentAmount = v - v * tax + currentAmount;
            count++;
        }
        return count;
    }
}