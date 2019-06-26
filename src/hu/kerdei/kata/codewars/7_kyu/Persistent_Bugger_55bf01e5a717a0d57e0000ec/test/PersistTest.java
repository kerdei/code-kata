import static org.junit.Assert.*;
import org.junit.Test;

public class PersistTest {

    @Test
    public void singleDigitTest(){
        assertEquals(0, Persist.persistence(4));
    }

    @Test
    public void twoDigitTest(){
        assertEquals(1, Persist.persistence(12));
    }

    @Test
    public void BasicTests() {
        assertEquals(3, Persist.persistence(39));
        assertEquals(0, Persist.persistence(4));
        assertEquals(2, Persist.persistence(25));
        assertEquals(4, Persist.persistence(999));
    }

}
