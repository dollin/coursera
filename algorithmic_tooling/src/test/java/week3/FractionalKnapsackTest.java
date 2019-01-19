package week3;

import static week3.FractionalKnapsack.*;
import org.junit.Assert;
import org.junit.Test;

public class FractionalKnapsackTest {

    @Test
    public void optimal() {
        double tolerance = 0.0001;
        Assert.assertEquals(180.0000, getOptimalValue(50, new int[]{60, 100, 120}, new int[]{20, 50, 30}), tolerance);
        Assert.assertEquals(166.6667, getOptimalValue(10, new int[]{500}, new int[]{30}), tolerance);
    }
}
