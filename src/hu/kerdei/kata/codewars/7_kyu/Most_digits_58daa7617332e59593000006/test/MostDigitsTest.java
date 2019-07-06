import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MostDigitsTest {

    @Test
    public void reallyLongNumberOneBesidesSmallOnes() {
        assertEquals(5000, MostDigits.findLongest(new int[]{1, 2, 5, 10, 5000, 1, 2, 3}));
        assertEquals(15000, MostDigits.findLongest(new int[]{15000, 1, 2, 5, 10, 1, 2, 3}));
        assertEquals(250, MostDigits.findLongest(new int[]{1, 2, 5, 10, 15, 1, 2, 250}));
        assertEquals(7000, MostDigits.findLongest(new int[]{1, 2, 5, 10, 25, 7000, 2, 3}));
    }

    @Test
    public void sameDigitNumber() {
        assertEquals(12, MostDigits.findLongest(new int[]{12, 23, 51, 12, 14, 76, 14, 12}));
        assertEquals(4111, MostDigits.findLongest(new int[]{4111, 7123, 1426}));
        assertEquals(1, MostDigits.findLongest(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void minusNumberTest() {
        assertEquals(-765, MostDigits.findLongest(new int[]{-765, 321, 151, 152, 124, 716, 164, 121}));
        assertEquals(12, MostDigits.findLongest(new int[]{12, 15, 12, 15, 14, 12, -18, 12}));
        assertEquals(321, MostDigits.findLongest(new int[]{-75, 321, 151, 152, 124, 716, 164, 121}));

    }

    @Test
    public void mixedNumbers() {
        assertEquals(120, MostDigits.findLongest(new int[]{120, 15, 121, 15, 154, 112, -18, 12}));
        assertEquals(1426, MostDigits.findLongest(new int[]{15, 18, 1426, 12, 85}));
        assertEquals(250, MostDigits.findLongest(new int[]{1, 2, 5, 10, 15, 1, 2, 250, 1, 65, 12, 65}));
    }


}