import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {

    @Test
    public void findShort() {
        assertEquals(3, Kata.findShort("bitcoin take over the world maybe who knows perhaps"));
        assertEquals(3, Kata.findShort("turns out random test cases are easier than writing out basic ones"));
    }


    @Test
    public void findBetweenLongs() {
        assertEquals(2, Kata.findShort("Maecenas elementum sodales quam, in tristiqueer eros mollis at"));
        assertEquals(2, Kata.findShort("Maecenas et risus vitae ligula consequat facilisis"));
    }

    @Test
    public void findLongOne() {
        assertEquals(5, Kata.findShort("Luctu tincidunt luctusy. Pellentesque gravida hendrerit condimentum."));
    }


}