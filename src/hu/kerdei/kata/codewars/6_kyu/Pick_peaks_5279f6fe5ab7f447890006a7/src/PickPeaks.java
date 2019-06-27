import java.util.*;

class PickPeaks {
    //TODO This kata needs to be redone
    public static Map<String, List<Integer>> getPeaks(int[] arr) {

        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> poss = new ArrayList<>();
        List<Integer> peaks = new ArrayList<>();

        for (int i = 1; i < arr.length - 1; i++) {
            int beforeNumber = arr[i - 1];
            int afterNumber = arr[i];
            int currentNumber = arr[i];
            int plateauLength = 0;

            for (int j = i + 1; j < arr.length - 1 && currentNumber == arr[j]; j++) {
                plateauLength++;
                afterNumber = arr[j + 1];
            }

            if (plateauLength == 0) {
                //We only have to check neighbours if there is no plateau
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    poss.add(i);
                    peaks.add(arr[i]);
                }
            } else {
                if (currentNumber > beforeNumber && currentNumber > afterNumber) {
                    poss.add(i);
                    peaks.add(arr[i]);

                    for (int j = i + 1; j < arr.length && arr[j] == arr[i]; j++) {
                        i++;
                        //Edge check
                        if (j + 1 == arr.length) {
                            poss.remove(poss.size() - 1);
                            peaks.remove(peaks.size() - 1);
                        }
                    }
                }
            }

        }

        map.put("pos", poss);
        map.put("peaks", peaks);
        return map;
    }

}
