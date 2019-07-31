import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void zeroSecondTest() {
        assertEquals("makeReadable(0)", "00:00:00", HumanReadableTime.makeReadable(0));
    }

    @Test
    public void oneSecondTest() {
        assertEquals("makeReadable(1)", "00:00:01", HumanReadableTime.makeReadable(1));
    }

    @Test
    public void oneMinuteTest() {
        assertEquals("makeReadable(60)", "00:01:00", HumanReadableTime.makeReadable(60));
    }

    @Test
    public void oneHourTest() {
        assertEquals("makeReadable(3600)", "01:00:00", HumanReadableTime.makeReadable(3600));
    }

    @Test
    public void beforeOneMinuteTests() {
        assertEquals("makeReadable(5)", "00:00:05", HumanReadableTime.makeReadable(5));
        assertEquals("makeReadable(10)", "00:00:10", HumanReadableTime.makeReadable(10));
        assertEquals("makeReadable(15)", "00:00:15", HumanReadableTime.makeReadable(15));
        assertEquals("makeReadable(25)", "00:00:25", HumanReadableTime.makeReadable(25));

    }

    @Test
    public void beforeOneHourTests() {
        assertEquals("makeReadable(3005)", "00:50:05", HumanReadableTime.makeReadable(3005));
        assertEquals("makeReadable(2235)", "00:37:15", HumanReadableTime.makeReadable(2235));
        assertEquals("makeReadable(1345)", "00:22:25", HumanReadableTime.makeReadable(1345));

    }


    @Test
    public void afterOneHourTests() {
        assertEquals("makeReadable(6000)", "01:40:00", HumanReadableTime.makeReadable(6000));
        assertEquals("makeReadable(86399)", "23:59:59", HumanReadableTime.makeReadable(86399));
        assertEquals("makeReadable(359999)", "99:59:59", HumanReadableTime.makeReadable(359999));
        assertEquals("makeReadable(36000)", "10:00:00", HumanReadableTime.makeReadable(36000));
    }


}
