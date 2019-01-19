package week2;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {

    @Test(timeout = 5000L)
    public void fibonacci() {
        Assert.assertEquals(433494437, Fibonacci.calc_fib(43));
    }

    @Test(timeout = 10_000L)
    public void listAll() {
        for(int x = 0; x <= 100; x++) {
            StopWatch sw = new StopWatch();
            sw.start();
            System.out.println(x + ": " + Fibonacci.calc_fib(x) + " took " + sw.getTime());
        }
    }
}