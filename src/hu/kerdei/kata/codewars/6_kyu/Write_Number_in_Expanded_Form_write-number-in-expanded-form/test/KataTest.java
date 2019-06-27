import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class KataTest {
    @Test
    public void testOneDigit() {
        assertEquals("1", Kata.expandedForm(1));
        assertEquals("5", Kata.expandedForm(5));
    }

    @Test
    public void testTwoDigit() {
        assertEquals("10", Kata.expandedForm(10));
        assertEquals("10 + 2", Kata.expandedForm(12));
        assertEquals("20 + 5", Kata.expandedForm(25));
    }

    @Test
    public void testLotsOfDigits() {
        assertEquals("5000 + 100 + 20 + 3", Kata.expandedForm(5123));
        assertEquals("4000 + 2", Kata.expandedForm(4002));
        assertEquals("60000000 + 20", Kata.expandedForm(60000020));
    }
}