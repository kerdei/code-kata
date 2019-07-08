import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OppositeTest {

    @Test
    public void zeroTest() {
        assertEquals(0, Opposite.opposite(0));
    }

    @Test
    public void positiveNumbers() {
        assertEquals(-1, Opposite.opposite(1));
        assertEquals(-12, Opposite.opposite(12));
        assertEquals(-151, Opposite.opposite(151));
        assertEquals(-1312, Opposite.opposite(1312));
        assertEquals(-82315, Opposite.opposite(82315));
        assertEquals(-4231, Opposite.opposite(4231));
        assertEquals(-32512, Opposite.opposite(32512));
    }

    @Test
    public void negativeNumbers() {
        assertEquals(1, Opposite.opposite(-1));
        assertEquals(12, Opposite.opposite(-12));
        assertEquals(151, Opposite.opposite(-151));
        assertEquals(1312, Opposite.opposite(-1312));
        assertEquals(82315, Opposite.opposite(-82315));
        assertEquals(4231, Opposite.opposite(-4231));
        assertEquals(32512, Opposite.opposite(-32512));
    }
}