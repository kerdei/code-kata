import java.util.ArrayList;
import java.util.List;

class Kata {

    static List<Long> possibleNumbers;

    static long nextBiggerNumber(long n) {
        String numberInString = String.valueOf(n);
        possibleNumbers = new ArrayList<>();
        permute(String.valueOf(n), 0, numberInString.length() - 1, n);
        return findNextBiggerNumberInAList(possibleNumbers, n);
    }

    private static Long findNextBiggerNumberInAList(List<Long> possibleNumbers, long givenNumber) {
        return possibleNumbers.stream().filter(num -> num > givenNumber).sorted().findFirst().orElse(-1L);
    }

    private static void permute(String str, int l, long r, long givenNumber) {
        if (l == r) {
            Long possibleNumber = Long.valueOf(str);
            if (possibleNumber > givenNumber || !possibleNumbers.contains(possibleNumber)) {
                possibleNumbers.add(possibleNumber);
            }
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r, givenNumber);
                str = swap(str, l, i);
            }
        }
    }

    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }


}