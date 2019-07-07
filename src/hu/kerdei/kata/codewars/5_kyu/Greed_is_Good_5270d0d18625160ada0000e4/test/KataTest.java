import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {


    @Test
    public void simpleTests1() {
        assertEquals("Score for [1,1,5,5,1] must be 1100:", 1100, Greed.greedy(new int[]{1, 1, 5, 5, 1}));
    }

    @Test
    public void simpleTests2() {
        assertEquals("Score for [6,6,6,1,5] must be 750:", 750, Greed.greedy(new int[]{6, 6, 6, 1, 5}));
    }

    @Test
    public void simpleTests3() {
        assertEquals("Score for [5,3,5,1,5] must be 600:", 600, Greed.greedy(new int[]{5, 3, 5, 1, 5}));
    }

    @Test
    public void testExample() {
        assertEquals("Score for [5,1,3,4,1] must be 250:", 250, Greed.greedy(new int[]{5, 1, 3, 4, 1}));
        assertEquals("Score for [1,1,1,3,1] must be 1100:", 1100, Greed.greedy(new int[]{1, 1, 1, 3, 1}));
        assertEquals("Score for [2,4,4,5,4] must be 450:", 450, Greed.greedy(new int[]{2, 4, 4, 5, 4}));
    }
}