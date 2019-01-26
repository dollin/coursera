package week6;

import org.junit.Assert;
import org.junit.Test;

public class WeekSixTest {

    @Test
    public void gold() {
        Assert.assertEquals(9, Knapsack.optimalWeight(10, new int[]{1, 4, 8}));
        Assert.assertEquals(9, Knapsack.optimalWeight(10, new int[]{3, 3, 3, 20}));
        Assert.assertEquals(10, Knapsack.optimalWeight(10, new int[]{3, 3, 3, 10}));
        Assert.assertEquals(19, Knapsack.optimalWeight(20, new int[]{5, 7, 12, 18}));
        Assert.assertEquals(20, Knapsack.optimalWeight(20, new int[]{3, 4, 6, 11, 13, 15}));
    }

    @Test
    public void placingParentheses() {
        Assert.assertEquals(200, PlacingParentheses.getMaximValue("5-8+7*4-8+9"));
        Assert.assertEquals(10, PlacingParentheses.getMaximValue("1+9"));
        Assert.assertEquals(22_876_792_454_961L, PlacingParentheses.getMaximValue("9*9*9*9*9*9*9*9*9*9*9*9*9*9"));

    }
}
