import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {
    @Test
    public void basicTest1() {
        assertEquals(51, Kata.nextBiggerNumber(15));
    }

    @Test
    public void basicTest2() {
        assertEquals(231, Kata.nextBiggerNumber(213));
    }

    @Test
    public void basicTest3() {
        assertEquals(2103, Kata.nextBiggerNumber(2031));
    }

    @Test
    public void noBiggerNumberAvailable1() {
        assertEquals(-1, Kata.nextBiggerNumber(9));
    }


    @Test
    public void noBiggerNumberAvailable2() {
        assertEquals(-1, Kata.nextBiggerNumber(111));
    }


    @Test
    public void noBiggerNumberAvailable3() {
        assertEquals(-1, Kata.nextBiggerNumber(531));
    }

    @Test
    public void basicTests() {
        assertEquals(21, Kata.nextBiggerNumber(12));
        assertEquals(531, Kata.nextBiggerNumber(513));
        assertEquals(2071, Kata.nextBiggerNumber(2017));
        assertEquals(441, Kata.nextBiggerNumber(414));
        assertEquals(414, Kata.nextBiggerNumber(144));
    }

    @Test
    public void biggerNumberTest() {
        assertEquals(1234567908, Kata.nextBiggerNumber(1234567890));
    }
}