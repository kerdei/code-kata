import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {
    @Test
    public void oneCharShouldReturnItself() {
        assertEquals("a", Kata.solution("a"));
    }

    @Test
    public void easyTest() {
        assertEquals("dlrow", Kata.solution("world"));
    }

    @Test
    public void easyTest2() {
        assertEquals("cat", Kata.solution("tac"));
    }


    @Test
    public void EmptyShouldReturnEmpty() {
        assertEquals("", Kata.solution(""));
    }

}