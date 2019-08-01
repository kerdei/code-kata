import static org.junit.Assert.*;

import org.junit.Test;

public class RowSumOddNumbersTest {

    @Test
    public void firstRowTest() {
        assertEquals(1, RowSumOddNumbers.rowSumOddNumbers(1));
    }

    @Test
    public void secondRowTest() {
        assertEquals(8, RowSumOddNumbers.rowSumOddNumbers(2));
    }

    @Test
    public void thirdRowTest() {
        assertEquals(27, RowSumOddNumbers.rowSumOddNumbers(3));
    }

    @Test
    public void forthRowTest() {
        assertEquals(64, RowSumOddNumbers.rowSumOddNumbers(4));
    }

    @Test
    public void fifthRowTest() {
        assertEquals(125, RowSumOddNumbers.rowSumOddNumbers(5));
    }

    @Test
    public void bigNRowTest() {
        assertEquals(74088, RowSumOddNumbers.rowSumOddNumbers(42));
    }
}