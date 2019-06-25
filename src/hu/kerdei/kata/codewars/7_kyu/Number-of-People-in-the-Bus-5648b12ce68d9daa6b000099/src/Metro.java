import java.util.ArrayList;

class Metro {

    public static int countPassengers(ArrayList<int[]> stops) {
        int currentNumber = 0;

        // int sum = stops.stream().mapToInt(x -> x[0] - x[1]).sum();

        for (int[] stop : stops) {
            currentNumber += stop[0];
            currentNumber -= stop[1];
        }
        return currentNumber;
    }
}