import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class ResultUnit {

    String value;
    String prefix;

    public ResultUnit(String value, String prefix) {
        this.value = value;
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return prefix + ":" + value + "/";
    }
}

public class Mixing {

    public static String mix(String s1, String s2) {

        //prepare strings
        s1 = s1.replaceAll("[^a-z]", "");
        s2 = s2.replaceAll("[^a-z]", "");

        Map<Integer, Long> s1GroupCharsByCount = s1
                .chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Integer, Long> s2GroupCharsByCount = s2
                .chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Integer, Long> mergedMaps = new HashMap<>();
        mergedMaps.putAll(s1GroupCharsByCount);

        s2GroupCharsByCount.forEach((key, value) -> mergedMaps.merge(key, value, (v1, v2) -> v1 > v2 ? v1 : v2));

        LinkedHashMap<Integer, Long> filteredStringMerged = mergedMaps.entrySet().stream().filter(e1 -> e1.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


        ArrayList<ResultUnit> resultUnitsList = new ArrayList<>();
        mergedStringsIntoResultUnitList(s1GroupCharsByCount, s2GroupCharsByCount, filteredStringMerged, resultUnitsList);

        if (resultUnitsList.size() == 0) {
            return "";
        }

        List<ResultUnit> sortedResultList = resultUnitsList.stream().sorted((o1, o2) -> {
            if (o1.value.length() == o2.value.length()) {
                if (o1.prefix.compareTo(o2.prefix) == 0) {
                    return o1.value.compareTo(o2.value);
                }

                return o1.prefix.compareTo(o2.prefix);
            }

            return o1.value.length() > o2.value.length() ? -1 : 1;

        }).collect(Collectors.toList());

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < sortedResultList.size(); i++) {
            stringBuilder.append(sortedResultList.get(i));
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();

    }

    private static void mergedStringsIntoResultUnitList(Map<Integer, Long> s1GroupCharsByCount, Map<Integer, Long> s2GroupCharsByCount, LinkedHashMap<Integer, Long> filteredStringMerged, ArrayList<ResultUnit> arrayList) {
        for (Map.Entry<Integer, Long> integerLongEntry : filteredStringMerged.entrySet()) {
            Long s1Value = s1GroupCharsByCount.get(integerLongEntry.getKey()) != null ? s1GroupCharsByCount.get(integerLongEntry.getKey()) : 0L;
            Long s2Value = s2GroupCharsByCount.get(integerLongEntry.getKey()) != null ? s2GroupCharsByCount.get(integerLongEntry.getKey()) : 0L;
            String c = Character.toString(integerLongEntry.getKey());
            StringBuilder stringBuilder = new StringBuilder();
            if (s1Value.equals(s2Value)) {
                for (int i = 0; i < s1Value; i++) {
                    stringBuilder.append(c);
                }
                arrayList.add(new ResultUnit(stringBuilder.toString(), "="));
                continue;
            }
            if (s1Value > s2Value) {
                for (int i = 0; i < s1Value; i++) {
                    stringBuilder.append(c);
                }
                arrayList.add(new ResultUnit(stringBuilder.toString(), "1"));
            } else {
                for (int i = 0; i < s2Value; i++) {
                    stringBuilder.append(c);
                }
                arrayList.add(new ResultUnit(stringBuilder.toString(), "2"));
            }
        }
    }

}