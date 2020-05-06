package base_classes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilsTest {
    private String data = "random=word?<random>random12.32random23.123.135.432adasdrandom";

    @Test
    public void getIpAddress() {
        assertEquals("23.123.135.432", Utils.getIpAddress(data));
    }
}
