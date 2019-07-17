import java.util.Arrays;
import java.util.stream.Collectors;

class PigLatin {
    static String pigIt(String str) {
        return Arrays.stream(str.split(" "))
                .map(x -> Character.isLetter(x.charAt(0)) ? x.substring(1) + x.charAt(0) + "ay" : x)
                .collect(Collectors.joining(" "));
    }
}