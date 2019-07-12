import org.junit.Assert;
import org.junit.Test;

public class MaskifyTest {

    @Test
    public void simpleTests() {
        Assert.assertEquals("123456 should be: ##3456", "##3456", Maskify.maskify("123456"));
        Assert.assertEquals("512345123 should be: #####5123", "#####5123", Maskify.maskify("512345123"));
        Assert.assertEquals("3412asdasddas should be: #########ddas", "#########ddas", Maskify.maskify("3412asdasddas"));
        Assert.assertEquals("TRIEKDIRJWKLROTITLWLERLW should be: ####################ERLW", "####################ERLW", Maskify.maskify("TRIEKDIRJWKLROTITLWLERLW"));

    }

    @Test
    public void shortOneTest() {
        Assert.assertEquals("12", "12", Maskify.maskify("12"));
        Assert.assertEquals("5", "5", Maskify.maskify("5"));
        Assert.assertEquals("9", "9", Maskify.maskify("9"));
        Assert.assertEquals("123", "123", Maskify.maskify("123"));
        Assert.assertEquals("1531", "1531", Maskify.maskify("1531"));
    }

    @Test
    public void fiveCharTests(){
        Assert.assertEquals("15311", "#5311", Maskify.maskify("15311"));
        Assert.assertEquals("65272", "#5272", Maskify.maskify("65272"));
        Assert.assertEquals("ABAQW", "#BAQW", Maskify.maskify("ABAQW"));
    }

    @Test
    public void emptyString() {
        Assert.assertEquals("\"\" should be: \"\"", "", Maskify.maskify(""));
    }

}