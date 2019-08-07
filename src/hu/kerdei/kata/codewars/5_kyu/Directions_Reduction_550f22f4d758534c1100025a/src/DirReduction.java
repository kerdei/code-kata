import java.util.List;

//too many iterations but works
public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        List<String> stringList = new java.util.ArrayList<>(List.of(arr));
        while (isThereAWasteOfDirections(stringList)) {
            for (int i = 0; i < stringList.size() - 1; i++) {
                if (isOpposite(stringList.get(i), stringList.get(i + 1))) {
                    stringList.remove(i);
                    stringList.remove(i);
                }
            }
        }
        return stringList.toArray(new String[0]);
    }

    private static boolean isThereAWasteOfDirections(List<String> stringList) {
        for (int i = 0; i < stringList.size() - 1; i++) {
            if (isOpposite(stringList.get(i), stringList.get(i + 1))) {
                return true;
            }
        }
        return false;
    }


    private static boolean isOpposite(String direction1, String direction2) {
        return direction1.equals("NORTH") && direction2.equals("SOUTH") || direction1.equals("SOUTH") && direction2.equals("NORTH") ||
                direction1.equals("EAST") && direction2.equals("WEST") || direction1.equals("WEST") && direction2.equals("EAST");
    }
}
