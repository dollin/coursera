package week2;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Assert;
import org.junit.Test;

public class FibonacciSumLastDigitTest {

    @Test(timeout = 1500L)
    public void sumLastDigit() {
        Assert.assertEquals(4, FibonacciSumLastDigit.getFibonacciSumLastDigit(3));
        Assert.assertEquals(5, FibonacciSumLastDigit.getFibonacciSumLastDigit(100));
        Assert.assertEquals(7, FibonacciSumLastDigit.getFibonacciSumLastDigit(331));
        Assert.assertEquals(2, FibonacciSumLastDigit.getFibonacciSumLastDigit(327_305));
        Assert.assertEquals(3, FibonacciSumLastDigit.getFibonacciSumLastDigit(832_564_823_476L));
        Assert.assertEquals(5, FibonacciSumLastDigit.getFibonacciSumLastDigit(1_000_000_000_000_000_000L));
    }

    @Test(timeout = 10_000L)
    public void listAll() {
        for(int x = 0; x <= 10_000_000; x++) {
            StopWatch sw = new StopWatch();
            sw.start();
            System.out.println(x + ": " + FibonacciSumLastDigit.getFibonacciSumLastDigit(x) + " took " + sw.getTime());
        }
    }
}