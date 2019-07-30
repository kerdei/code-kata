import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CounterTest {

    @Test
    public void simpleTest1() {

        Boolean[] array = {true, true, true, false,
                true, true, true, true,
                true, false, true, false,
                true, false, false, true,
                true, true, true, true,
                false, false, true, true};

        assertEquals("There are 17 sheeps in total", 17, new Counter().countSheeps(array));
    }

    @Test
    public void simpleTest2() {

        Boolean[] array = {true, true, true, false,
                true, false, true, false,
                true, false, false, true,
                true, true, true, true,
                false, false, true, true};
        assertEquals("There are 13 sheeps in total", 13, new Counter().countSheeps(array));
    }

    @Test
    public void simpleTest3() {
        Boolean[] array = {false, false, false, false,
                false, false, false, false,
                false, false, false, false,
                false, false, false, false,
                false, false, false, false};
        assertEquals("There are 0 sheeps in total", 0, new Counter().countSheeps(array));
    }

    @Test
    public void nullTest() {
        Boolean[] nullArrayTest = {true, true, true, false,
                true, true, true, true,
                true, false, true, false,
                true, false, null, true,
                true, true, true, true,
                false, false, true, true};

        assertEquals("There are 17 sheeps in total", 17, new Counter().countSheeps(nullArrayTest));
    }
}