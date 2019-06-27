public class Solution {
    public static char findMissingLetter(char[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] - 1 != array[i - 1]) return (char) (array[i] - 1);
        }
		throw new IllegalArgumentException("Should not happen!");
    }
}