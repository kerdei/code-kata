import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {
    @Test
    public void evenTests() {
        assertEquals("a",Kata.getMiddle("a"));
        assertEquals("a",Kata.getMiddle("aaa"));
        assertEquals("b",Kata.getMiddle("aba"));
        assertEquals("x",Kata.getMiddle("LongExample"));
    }

    @Test
    public void oddTests() {
        assertEquals("aa",Kata.getMiddle("aa"));
        assertEquals("aa",Kata.getMiddle("aaaa"));
        assertEquals("cc",Kata.getMiddle("aaccaa"));
        assertEquals("cb",Kata.getMiddle("aacbaa"));
    }
}