import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MetroTest {
    @Test
    public void testSample() {
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[] {10,0});
        list.add(new int[] {3,5});
        list.add(new int[] {2,5});
        assertEquals(5, Metro.countPassengers(list));
    }

    @Test
    public void testNobody() {
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[] {0,0});
        list.add(new int[] {0,0});
        list.add(new int[] {0,0});
        assertEquals(0, Metro.countPassengers(list));
    }

    @Test
    public void testSleeperBus() {
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[] {4,0});
        list.add(new int[] {5,0});
        list.add(new int[] {2,0});
        list.add(new int[] {6,0});
        list.add(new int[] {7,0});
        assertEquals(24, Metro.countPassengers(list));
    }


}