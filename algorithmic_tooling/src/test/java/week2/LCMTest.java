package week2;

import org.junit.Assert;
import org.junit.Test;

public class LCMTest {

    @Test(timeout = 5_000L)
    public void lcm() {
        Assert.assertEquals(24, LCM.lcm(8, 6));
        Assert.assertEquals(1_933_053_046, LCM.lcm(28_851_538, 1_183_019));
    }
}