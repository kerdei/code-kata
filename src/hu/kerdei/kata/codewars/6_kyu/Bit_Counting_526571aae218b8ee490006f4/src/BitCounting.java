public class BitCounting {

    public static int countBits(int n) {
        return Integer.toBinaryString(n).chars().map(Character::getNumericValue).sum();
    }

}