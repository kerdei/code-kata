import static org.junit.Assert.*;

import org.junit.Test;


public class AreSameTest {

    @Test
    public void test1() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertEquals(true, AreSame.comp(a, b));
    }

    @Test
    public void test2() {
        int[] a = new int[]{19, 11};
        int[] b = new int[]{131, 361};
        assertEquals(false, AreSame.comp(a, b));
    }

    @Test
    public void test3() {
        int[] a = new int[]{19, 11};
        int[] b = new int[]{121, 361};
        assertEquals(true, AreSame.comp(a, b));
    }


    @Test
    public void test4() {
        int[] a = new int[]{2, 2, 3};
        int[] b = new int[]{4, 9, 9};
        assertEquals(false, AreSame.comp(a, b));
    }

    @Test
    public void testNull() {
        int[] a = new int[]{19, 11};
        assertEquals(false, AreSame.comp(a, null));
        assertEquals(false, AreSame.comp(null, a));
    }

    @Test
    public void testNotEqualLength() {
        int[] a = new int[]{19, 11};
        int[] b = new int[]{};
        assertEquals(false, AreSame.comp(a, b));
        assertEquals(false, AreSame.comp(b, a));
    }
}