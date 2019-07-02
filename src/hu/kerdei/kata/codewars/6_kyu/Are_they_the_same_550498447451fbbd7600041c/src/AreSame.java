import java.util.Arrays;

public class AreSame {

    public static boolean comp(int[] aints, int[] bints) {
        if (aints == null || bints == null || aints.length != bints.length) {
            return false;
        }

        int[] aIntsSquared = Arrays.stream(aints).map(x -> x * x).toArray();

        Arrays.sort(aIntsSquared);
        Arrays.sort(bints);
        return Arrays.equals(aIntsSquared,bints);
    }

}