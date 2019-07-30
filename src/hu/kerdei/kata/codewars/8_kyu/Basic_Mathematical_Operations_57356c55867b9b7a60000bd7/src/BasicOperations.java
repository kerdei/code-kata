public class BasicOperations {
    public static Integer basicMath(String op, int v1, int v2) {
        int result = 0;
        switch (op) {
            case "*":
                result = multiplication(v1, v2);
                break;
            case "/":
                result = division(v1, v2);
                break;
            case "+":
                result = summation(v1, v2);
                break;
            case "-":
                result = subtraction(v1, v2);
                break;
        }
        return result;
    }

    private static int subtraction(int v1, int v2) {
        return v1 - v2;
    }

    private static int summation(int v1, int v2) {
        return v1 + v2;
    }

    private static int division(int v1, int v2) {
        return v1 / v2;
    }

    private static int multiplication(int v1, int v2) {
        return v1 * v2;
    }
}