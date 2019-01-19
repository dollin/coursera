package week3;

import org.junit.Assert;
import org.junit.Test;

public class DotProductTest {

    @Test
    public void dotProduct() {
        Assert.assertEquals(38, DotProduct.maxDotProduct(new int[]{6, 1, 2}, new int[]{2, 5, 3}));
        Assert.assertEquals(23, DotProduct.maxDotProduct(new int[]{1, 3, -5}, new int[]{-2, 4, 1}));
        Assert.assertEquals(4611686014132420609L, DotProduct.maxDotProduct(new int[]{Integer.MAX_VALUE}, new int[]{Integer.MAX_VALUE}));

    }
}