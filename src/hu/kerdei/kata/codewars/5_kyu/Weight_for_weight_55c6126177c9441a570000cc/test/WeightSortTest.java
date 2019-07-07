import static org.junit.Assert.*;

import org.junit.Test;

public class WeightSortTest {


    @Test
    public void testSimpleWeights1() {
        assertEquals("12 31 14 16 65", WeightSort.orderWeight("14 12 16 31 65"));
    }

    @Test
    public void testSimpleWeights2() {
        assertEquals("2000 103 123 4444 99", WeightSort.orderWeight("103 123 4444 99 2000"));
    }

    @Test
    public void testSameValuedWeights1() {
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", WeightSort.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }

    @Test
    public void testSameValuedWeights2() {
        assertEquals("12 22 31 14 16 65", WeightSort.orderWeight("14 22 12 16 31 65"));
    }
}
