import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpinWordsTest {
    @Test
    public void test() {
        assertEquals("emocleW", new SpinWords().spinWords("Welcome"));
        assertEquals("Hey wollef sroirraw", new SpinWords().spinWords("Hey fellow warriors"));
    }

    @Test
    public void shouldNotChange1() {
        assertEquals("Test", new SpinWords().spinWords("Test"));
    }

    @Test
    public void shouldNotChange2() {
        assertEquals("Test with more word s", new SpinWords().spinWords("Test with more word s"));
    }

    @Test
    public void shouldNotChange3() {
        assertEquals("It shou ld be the same str ing", new SpinWords().spinWords("It shou ld be the same str ing"));
    }

    @Test
    public void reverseEverything() {
        assertEquals("gnihtyrevE dluohs desrevereb", new SpinWords().spinWords("Everything should bereversed"));
    }

}