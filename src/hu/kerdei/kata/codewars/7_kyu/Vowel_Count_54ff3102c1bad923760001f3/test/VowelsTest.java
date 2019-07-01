import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VowelsTest {
    @Test
    public void tests() {
        assertEquals("2 vowel test: abcde", 2, Vowels.getCount("abcde"));
        assertEquals("0 vowel test: dfgtrtz", 0, Vowels.getCount("dfgtrtz"));
        assertEquals("5 vowel test: abracadabra", 5, Vowels.getCount("abracadabra"));
        assertEquals("5 different vowel test: aeuio",5,Vowels.getCount("aeuio"));
    }

}