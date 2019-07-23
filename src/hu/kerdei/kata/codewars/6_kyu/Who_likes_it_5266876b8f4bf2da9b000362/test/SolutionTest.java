import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void noLikeTest(){
        assertEquals("no one likes this", Solution.whoLikesIt());
    }

    @Test
    public void oneLikeTest(){
        assertEquals("Peter likes this", Solution.whoLikesIt("Peter"));
        assertEquals("Tom likes this", Solution.whoLikesIt("Tom"));
        assertEquals("Sally likes this", Solution.whoLikesIt("Sally"));
        assertEquals("justalongerstringtotest likes this", Solution.whoLikesIt("justalongerstringtotest"));
    }

    @Test
    public void twoLikeTest(){
        assertEquals("Peter and Tom like this", Solution.whoLikesIt("Peter","Tom"));
        assertEquals("Tom and Peter like this", Solution.whoLikesIt("Tom","Peter"));
        assertEquals("Sally and Tom like this", Solution.whoLikesIt("Sally","Tom"));
        assertEquals("justalongerstringtotest and justanantherlongerrandomstring like this", Solution.whoLikesIt("justalongerstringtotest","justanantherlongerrandomstring"));
    }

    @Test
    public void threeLikeTest(){
        assertEquals("Peter, Tom and Shally like this", Solution.whoLikesIt("Peter","Tom","Shally"));
    }

    @Test
    public void fourAndMoreLikes() {
        assertEquals("Alex, Jacob and 2 others like this", Solution.whoLikesIt("Alex", "Jacob", "Mark", "Max"));
        assertEquals("Alex, Jacob and 5 others like this", Solution.whoLikesIt("Alex", "Jacob", "Mark", "Max" , "1more" , "2more" , "3 more"));
    }
}