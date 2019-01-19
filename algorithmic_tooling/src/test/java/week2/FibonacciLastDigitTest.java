package week2;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Assert;
import org.junit.Test;

public class FibonacciLastDigitTest {

    @Test(timeout = 5000L)
    public void fibonacciLastDigit() {
        Assert.assertEquals(9, FibonacciLastDigit.getFibonacciLastDigit(331));
        Assert.assertEquals(5, FibonacciLastDigit.getFibonacciLastDigit(327_305));
    }

    @Test(timeout = 10_000L)
    public void listAll() {
        for(int x = 0; x <= 10_000_000; x++) {
            StopWatch sw = new StopWatch();
            sw.start();
            System.out.println(x + ": " + FibonacciLastDigit.getFibonacciLastDigit(x) + " took " + sw.getTime());
        }
    }
}