package liande.cai.urlshorter.tool;

import org.junit.Assert;
import org.junit.Test;

/**
 * Description:
 * 
 * @author liandecai
 * @time Jun 20, 2014
 */
public class StringHasherTest {

    @Test
    public void testBase62() {
        Assert.assertEquals(Base62Converter.dec2base62(1), "b");
        Assert.assertEquals(Base62Converter.dec2base62(61), "9");
        Assert.assertEquals(Base62Converter.dec2base62(62), "ba");
    }

    @Test
    public void testGetIdBase62() {
        Assert.assertEquals(Base62Converter.base622dec("b"), 1);
        Assert.assertEquals(Base62Converter.base622dec("9"), 61);
        Assert.assertEquals(Base62Converter.base622dec("ba"), 62);
    }
}
