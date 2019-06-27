import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testLowerCased() {
        assertEquals('e', Solution.findMissingLetter(new char[]{'a', 'b', 'c', 'd', 'f'}));
    }

    @Test
    public void testUpperCased() {
        assertEquals('P', Solution.findMissingLetter(new char[]{'O', 'Q', 'R', 'S'}));
    }
}