package week5;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class WeekFiveTest {

    @Test
    public void primitiveCalculator() {
        Assert.assertEquals(1, PrimitiveCalculator.optimal_sequence(1).size());
        Assert.assertEquals(4, PrimitiveCalculator.optimal_sequence(5).size());
        Assert.assertEquals(4, PrimitiveCalculator.optimal_sequence(8).size());
        Assert.assertEquals(15, PrimitiveCalculator.optimal_sequence(96_234).size());
        Assert.assertEquals(15, PrimitiveCalculator.optimal_sequence(10_000_000).size());
    }

    @Test(timeout = 30_000)
    public void primitiveCalculatorStress() {
        IntStream.rangeClosed(1, 500_000).forEach(PrimitiveCalculator::optimal_sequence);
    }

        @Test
    public void moneyChange() {
        Assert.assertEquals(2, ChangeDP.getChange(2));
        Assert.assertEquals(9, ChangeDP.getChange(34));
        Assert.assertEquals(2_500, ChangeDP.getChange(10_000));
    }
}
