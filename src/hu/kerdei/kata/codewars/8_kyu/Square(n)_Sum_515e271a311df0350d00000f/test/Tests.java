import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {

    @Test
    public void zeroTest() {
        assertEquals(0, Kata.squareSum(new int[]{0}));
        assertEquals(0, Kata.squareSum(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

    @Test
    public void oneNumberTest() {
        assertEquals(1, Kata.squareSum(new int[]{1}));
        assertEquals(4, Kata.squareSum(new int[]{2}));
        assertEquals(9, Kata.squareSum(new int[]{3}));
        assertEquals(3025, Kata.squareSum(new int[]{55}));
    }

    @Test
    public void twoNumber() {
        assertEquals(3026, Kata.squareSum(new int[]{55, 1}));
        assertEquals(3029, Kata.squareSum(new int[]{55, 2}));
        assertEquals(3034, Kata.squareSum(new int[]{3, 55}));
        assertEquals(6050, Kata.squareSum(new int[]{55, 55}));
    }

    @Test
    public void complexTest() {
        assertEquals(3055, Kata.squareSum(new int[]{1, 2, 3, 4, 55}));
    }

    @Test
    public void givenTests() {
        assertEquals(9, Kata.squareSum(new int[]{1, 2, 2}));
        assertEquals(5, Kata.squareSum(new int[]{1, 2}));
        assertEquals(50, Kata.squareSum(new int[]{5, -3, 4}));
    }
}