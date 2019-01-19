package week1;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class MaxPairwiseProductTest {

    @Test
    public void t1() {
        int[] numbers = new int[]{1,2,3, 4,5,6,7,8,9,10,1,2,3, 4,5,6,7,8,9,10};

        Assert.assertEquals(100, MaxPairwiseProduct.getMaxPairwiseProduct(numbers));
    }

    @Test
    public void t2() {
        int[] numbers = new int[]{68165, 87637, 74297, 2904, 32873, 86010, 87637, 66131, 82858, 82935};

        Assert.assertEquals(7_680_243_769L, MaxPairwiseProduct.getMaxPairwiseProduct(numbers));

    }

    @Test
    public void t3() {
        int[] numbers = new int[]{100_000, 90_000};
        Assert.assertEquals(9_000_000_000L, MaxPairwiseProduct.getMaxPairwiseProduct(numbers));
    }

    @Test
    public void stressTest() {
        int tests = 100;

        IntStream.range(0, tests).forEach(value -> {
            int maxNumber = 100_000;
            int maxArray = 50_000;
            int[] numbers = new int[(int) ((Math.random() * maxArray) % maxArray)];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = (int) ((Math.random() * maxNumber) % maxNumber);
            }
            Assert.assertEquals(MaxPairwiseProduct.getMaxPairwiseProduct(numbers), MaxPairwiseProduct.getMaxPairwiseProduct(numbers));
        });
    }
}