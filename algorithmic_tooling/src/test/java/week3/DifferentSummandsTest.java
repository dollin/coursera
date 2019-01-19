package week3;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DifferentSummandsTest {

    @Test
    public void differentSummands1() {
        List<Integer> result = DifferentSummands.optimalSummands(6);
        Assert.assertEquals(3, result.size());
        Assert.assertEquals(1, (int) result.get(0));
        Assert.assertEquals(2, (int) result.get(1));
        Assert.assertEquals(3, (int) result.get(2));
    }

    @Test
    public void differentSummands2() {
        List<Integer> result = DifferentSummands.optimalSummands(8);
        Assert.assertEquals(3, result.size());
        Assert.assertEquals(1, (int) result.get(0));
        Assert.assertEquals(2, (int) result.get(1));
        Assert.assertEquals(5, (int) result.get(2));
    }

    @Test
    public void differentSummands4() {
        List<Integer> result = DifferentSummands.optimalSummands(10);
        Assert.assertEquals(4, result.size());
        Assert.assertEquals(1, (int) result.get(0));
        Assert.assertEquals(2, (int) result.get(1));
        Assert.assertEquals(3, (int) result.get(2));
        Assert.assertEquals(4, (int) result.get(3));
    }

    @Test
    public void differentSummands3() {
        List<Integer> result = DifferentSummands.optimalSummands(2);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(2, (int) result.get(0));
    }
}