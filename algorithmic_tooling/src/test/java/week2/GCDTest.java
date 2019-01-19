package week2;

import org.junit.Assert;
import org.junit.Test;

public class GCDTest {

    @Test(timeout = 5_000L)
    public void gcd() {
        Assert.assertEquals(61_232, GCD.gcd_euclid(3_918_848, 1_653_264));
        Assert.assertEquals(17_657, GCD.gcd_euclid(28_851_538, 1_183_019));
    }
}