import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateColorRGB {

    public static String generateColor(Random r) {

        StringBuilder sb = new StringBuilder(7).append("#");

        for (int i = 0; i < 6; i++) {
            boolean digitOrLetter = ThreadLocalRandom.current().nextBoolean();

            if (digitOrLetter) {
                //numbers 0-9
                sb.append((char) ThreadLocalRandom.current().nextInt(48, 57));
            } else {
                //letters A-F
                sb.append((char) ThreadLocalRandom.current().nextInt(65, 70));
            }
        }
        return sb.toString();
    }

}
