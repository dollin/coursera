package week2;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciHugeTest {

    @Test(timeout = 500L)
    public void fibonacciHuge() {
        Assert.assertEquals(1, FibonacciHuge.getFibonacciHuge(2_015, 3));
        Assert.assertEquals(161, FibonacciHuge.getFibonacciHuge(239, 1_000));
        Assert.assertEquals(151, FibonacciHuge.getFibonacciHuge(2_816_213_588L, 239));
        Assert.assertEquals(521, FibonacciHuge.getFibonacciHuge(1_000_000_000_000_000_000L, 997));
    }
}