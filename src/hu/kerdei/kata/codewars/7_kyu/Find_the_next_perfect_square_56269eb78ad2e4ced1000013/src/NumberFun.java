public class NumberFun {
    public static long findNextSquare(long sq) {
        if (!isItAPerfectSquare(sq)) {
            return -1;
        }

        sq++;

        while (!isItAPerfectSquare(sq)) {
            sq++;
        }
        return sq;

    }

    private static boolean isItAPerfectSquare(long sq) {
        double sqrt = Math.sqrt(sq);
        return sqrt == Math.floor(sqrt);
    }
}