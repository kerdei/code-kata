import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class PickPeaksTest {

    @Test
    public void simpleTest() {
        int[] input = {1, 2, 3, 6, 4, 1, 2, 3, 2, 1};
        Map<String, List<Integer>> expected = new HashMap<>() {{
            put("pos", Arrays.asList(3, 7));
            put("peaks", Arrays.asList(6, 3));
        }};
        assertEquals(expected, PickPeaks.getPeaks(input));
    }

    @Test
    public void plateauTest() {
        int[] input = {3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 2, 2, 1};

        Map<String, List<Integer>> expected = new HashMap<>() {{
            put("pos", Arrays.asList(3, 7, 10));
            put("peaks", Arrays.asList(6, 3, 2));
        }};
        assertEquals(expected, PickPeaks.getPeaks(input));
    }


    @Test
    public void plateauLeftEdgeTest() {
        int[] input = {2, 2, 1, 6, 1, 1};

        Map<String, List<Integer>> expected = new HashMap<>() {{
            put("pos", Arrays.asList(3));
            put("peaks", Arrays.asList(6));
        }};
        assertEquals(expected, PickPeaks.getPeaks(input));
    }

    @Test
    public void complicatedTest1() {
        int[] input = {19, 1, 3, 9, 6, 17, 1, -1, 9, 10, 4, 8, 8, 16, -3, -5, 13, -3, 15, -5, 18};


        Map<String, List<Integer>> expected = new HashMap<>() {{
            put("pos", Arrays.asList(3, 5, 9, 13, 16, 18));
            put("peaks", Arrays.asList(9, 17, 10, 16, 13, 15));
        }};

        assertEquals(expected, PickPeaks.getPeaks(input));
    }

    @Test
    public void complicatedTest2() {
        int[] input = {8, -5, 19, -3, 18, 2, 4, -1, -2, -3, 7, 18, 4, 13, 10, -3, 12, -4, 7, 16, 2, 16, 16, 4, 9, 4, 14, -2, 15};


        Map<String, List<Integer>> expected = new HashMap<>() {{
            put("pos", Arrays.asList(2, 4, 6, 11, 13, 16, 19, 21, 24, 26));
            put("peaks", Arrays.asList(19, 18, 4, 18, 13, 12, 16, 16, 9, 14));
        }};

        assertEquals(expected, PickPeaks.getPeaks(input));
    }


    @Test
    public void complicatedTest3() {
        int[] input = {0, -1, 14, -5, -1, -3, 12, 5, 17, 5, 16, 17, 5, 17, 11, 11, -2, 12, 14, 11, 6, 4, -4, 2, 0, 9, 4, 11};


        Map<String, List<Integer>> expected = new HashMap<>() {{
            put("pos", Arrays.asList(2, 4, 6, 8, 11, 13, 18, 23, 25));
            put("peaks", Arrays.asList(14, -1, 12, 17, 17, 17, 14, 2, 9));
        }};

        assertEquals(expected, PickPeaks.getPeaks(input));
    }
}