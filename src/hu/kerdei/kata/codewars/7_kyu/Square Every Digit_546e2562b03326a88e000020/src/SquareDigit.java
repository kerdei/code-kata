import java.util.stream.Collectors;

public class SquareDigit {

    public int squareDigits(int n) {
        return Integer.valueOf(String.valueOf(n)
                .chars()
                .boxed()
                .map(Character::getNumericValue)
                .map(x -> String.valueOf(x * x))
                .collect(Collectors.joining("")));
    }
}