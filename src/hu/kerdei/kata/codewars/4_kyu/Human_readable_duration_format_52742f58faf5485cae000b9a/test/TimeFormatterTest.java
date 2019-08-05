import org.junit.Test;

import static org.junit.Assert.*;

public class TimeFormatterTest {

    @Test
    public void oneHourTest() {
        assertEquals("1 hour", TimeFormatter.formatDuration(3600));
    }

    @Test
    public void twoHourTest() {
        assertEquals("2 hours", TimeFormatter.formatDuration(7200));
    }

    @Test
    public void oneSecondTest() {
        assertEquals("1 second", TimeFormatter.formatDuration(1));
    }

    @Test
    public void oneDayTest() {
        assertEquals("1 day", TimeFormatter.formatDuration(86400));
    }

    @Test
    public void twoMinuteTest() {
        assertEquals("2 minutes", TimeFormatter.formatDuration(120));
    }

    @Test
    public void advancedTests() {
        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662));
        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
    }

    @Test
    public void nowTest() {
        assertEquals("now", TimeFormatter.formatDuration(0));
    }
}
