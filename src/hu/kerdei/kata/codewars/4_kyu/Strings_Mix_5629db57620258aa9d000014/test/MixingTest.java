import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.Arrays;

import org.junit.Test;

public class MixingTest {

    @Test
    public void test1() {
        assertEquals("", Mixing.mix("codewars", "codewars"));

    }

    @Test
    public void test2() {
        assertEquals("1:aaa/1:nnn/1:gg/2:ee/2:ff/2:ii/2:oo/2:rr/2:ss/2:tt",
                Mixing.mix(" In many languages", " there's a pair of functions"));

    }

    @Test
    public void test3() {
        assertEquals("1:aaa/1:nnn/1:gg/2:ee/2:ff/2:ii/2:oo/2:rr/2:ss/2:tt",
                Mixing.mix(" In many languages", " there's a pair of functions"));

    }

    @Test
    public void test4() {
        assertEquals("1:ooo/1:uuu/2:sss/=:nnn/1:ii/2:aa/2:dd/2:ee/=:gg",
                Mixing.mix("looping is fun but dangerous", "less dangerous than coding"));

    }

    @Test
    public void test5() {
        assertEquals("2:eeeee/2:yy/=:hh/=:rr", Mixing.mix("Are they here", "yes, they are here"));

    }

    @Test
    public void test6() {
        assertEquals("1:ee/1:ll/1:oo",
                Mixing.mix("Lords of the Fallen", "gamekult"));

    }

    @Test
    public void test7() {
        assertEquals("1:nnnnn/1:ooooo/1:tttt/1:eee/1:gg/1:ii/1:mm/=:rr",
                Mixing.mix("A generation must confront the looming ", "codewarrs"));
    }

}