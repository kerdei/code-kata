//https://www.codewars.com/kata/54c27a33fb7da0db0100040e

public class Square {
    public static boolean isSquare(int n) {
        double sqrt = Math.sqrt(n);
        return sqrt == Math.floor(sqrt);
    }
}