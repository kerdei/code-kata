import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvenOrOddTest {

    @Test
    public void testOddTests() {
        assertEquals("Odd", EvenOrOdd.even_or_odd(7));
        assertEquals("Odd", EvenOrOdd.even_or_odd(13));
        assertEquals("Odd", EvenOrOdd.even_or_odd(341));
        assertEquals("Odd", EvenOrOdd.even_or_odd(1769));
        assertEquals("Odd", EvenOrOdd.even_or_odd(1211));
        assertEquals("Odd", EvenOrOdd.even_or_odd(-1));
        assertEquals("Odd", EvenOrOdd.even_or_odd(-1311));
    }

    @Test
    public void testEvenTests() {
        assertEquals("Even", EvenOrOdd.even_or_odd(12));
        assertEquals("Even", EvenOrOdd.even_or_odd(144));
        assertEquals("Even", EvenOrOdd.even_or_odd(1572));
        assertEquals("Even", EvenOrOdd.even_or_odd(1832));
        assertEquals("Even", EvenOrOdd.even_or_odd(-2));
        assertEquals("Even", EvenOrOdd.even_or_odd(-1222));
    }
}
