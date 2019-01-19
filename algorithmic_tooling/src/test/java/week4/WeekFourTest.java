package week4;

import static org.junit.Assert.assertEquals;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class WeekFourTest {

    @Test
    public void lotto1() {
        int[] starts = new int[]{0, 5};
        int[] ends = new int[]{5, 10};
        int[] points = new int[]{1, 6, 11};
        int[] expected = new int[]{1, 1, 0};
        Assert.assertArrayEquals(expected, PointsAndSegments.naiveCountSegments(starts, ends, points));
        Assert.assertArrayEquals(expected, PointsAndSegments.fastCountSegments(starts, ends, points));
    }

    @Test
    public void lotto2() {
        int[] starts = new int[]{-10};
        int[] ends = new int[]{10};
        int[] points = new int[]{-100, 100, 0};
        int[] expected = new int[]{0, 0, 1};
        Assert.assertArrayEquals(expected, PointsAndSegments.naiveCountSegments(starts, ends, points));
        Assert.assertArrayEquals(expected, PointsAndSegments.fastCountSegments(starts, ends, points));
    }

    @Test
    public void lotto3() {
        int[] starts = new int[]{0, -3, 7};
        int[] ends = new int[]{5, 2, 10};
        int[] points = new int[]{1, 6};
        int[] expected = new int[]{2, 0};
        Assert.assertArrayEquals(expected, PointsAndSegments.naiveCountSegments(starts, ends, points));
        Assert.assertArrayEquals(expected, PointsAndSegments.fastCountSegments(starts, ends, points));
    }

    @Test
    public void lotto4() {
        int[] starts = new int[]{1, 1};
        int[] ends = new int[]{2, 2};
        int[] points = new int[]{1, 2};
        int[] expected = new int[]{2, 2};
        Assert.assertArrayEquals(expected, PointsAndSegments.naiveCountSegments(starts, ends, points));
        Assert.assertArrayEquals(expected, PointsAndSegments.fastCountSegments(starts, ends, points));
    }

    @Test
    public void lotto5() {
        int[] starts = new int[]{-10, -8, 1, 2};
        int[] ends = new int[]{1, 1, 4, 5};
        int[] points = new int[]{-11, -10, -9, -8, -7, -5, 0};
        int[] expected = new int[]{0, 1, 1, 2, 2, 2, 2};
        Assert.assertArrayEquals(expected, PointsAndSegments.naiveCountSegments(starts, ends, points));
        Assert.assertArrayEquals(expected, PointsAndSegments.fastCountSegments(starts, ends, points));
    }

    @Test(timeout = 5_000)
    public void naivePointsAndSegmentsStress() {
        int noOfSegments = 100_000;
        int noOfPoints = 100_000;

        int[] starts = new int[noOfSegments];
        int[] ends = new int[noOfSegments];
        int[] points = new int[noOfPoints];

        for (int i = 0; i < noOfSegments; i++) {
            starts[i] = i;
            ends[i] =  i + 2;
        }

        int index = 0;
        for (int i = -noOfPoints; i < noOfPoints; i++) {
            points[index] = i;
        }

        StopWatch sw = new StopWatch();
        sw.start();
        PointsAndSegments.fastCountSegments(starts, ends, points);
        System.out.println("PointsAndSegments.fastCountSegments took: " + sw.getTime());
    }

    @Test
    public void inversions() {
        assertEquals(5, Inversions.countInversions(new int[]{ 1, 20, 6, 4, 5}, new int[5], 0, 4));
        assertEquals(15, Inversions.countInversions(new int[]{ 6, 5, 4, 3, 2, 1}, new int[6], 0, 5));
        assertEquals(0, Inversions.countInversions(new int[]{ 1, 2, 3, 4, 5, 6}, new int[6], 0, 5));
        assertEquals(2, Inversions.countInversions(new int[]{ 2, 3, 9, 2, 9}, new int[5], 0, 4));
    }

    @Test
    public void quickSort() {
        int[] a = {2, 1, 2, 5, 2, 9};
        Sorting.randomizedQuickSort(a, 0, a.length - 1);

        Assert.assertArrayEquals(new int[]{1, 2, 2, 2, 5, 9}, a);
    }

    @Test(timeout = 1_000)
    public void quickSortLarge() {
        int size = 1_000_000;
        Random rand = new Random();
        int[] a = new int[size];
        int[] b = new int[size];

        for (int i = 0; i < size; i++) {
            int number = rand.nextInt(size / 10_000);
            a[i] = number;
            b[i] = number;
        }

        StopWatch sw = new StopWatch();
        sw.start();

        Arrays.sort(b);
        System.out.println("Arrays.sort took: " + sw.getTime());

        sw.reset();
        sw.start();

        Sorting.randomizedQuickSort(a, 0, a.length - 1);
        System.out.println("Sorting.randomizedQuickSort took: " + sw.getTime());

        Assert.assertArrayEquals(b, a);
    }

    @Test
    public void majorityElement() {
        assertEquals(1, MajorityElement.getMajorityElement(new int[]{2, 3, 9, 2, 2}, 0, 5));
        assertEquals(0, MajorityElement.getMajorityElement(new int[]{1, 2, 3, 4}, 0, 4));
        assertEquals(0, MajorityElement.getMajorityElement(new int[]{1, 2, 3, 1}, 0, 4));
        assertEquals(0, MajorityElement.getMajorityElement(new int[]{1, 2, 2, 1}, 0, 4));
        assertEquals(1, MajorityElement.getMajorityElement(new int[]{1, 2, 2, 1, 1}, 0, 5));
        assertEquals(0, MajorityElement.getMajorityElement(new int[]{512766168, 717383758, 5, 126144732, 5, 573799007, 5, 5, 5, 405079772}, 0, 9));
    }

    @Test
    public void binarySearch() {
        int[] a = new int[]{1, 2, 3, 4, 5};
        assertEquals(0, BinarySearch.binarySearch(a, 1));
        assertEquals(1, BinarySearch.binarySearch(a, 2));
        assertEquals(2, BinarySearch.binarySearch(a, 3));
        assertEquals(3, BinarySearch.binarySearch(a, 4));
        assertEquals(4, BinarySearch.binarySearch(a, 5));
    }

    @Test
    public void binarySearch1() {
        int[] a = new int[]{1, 5, 7, 8, 12, 13};
        assertEquals(3, BinarySearch.binarySearch(a, 8));
        assertEquals(-1, BinarySearch.binarySearch(new int[0], 8));
    }

    @Test
    public void linearSearch() {
        int[] a = new int[]{1, 5, 8, 12, 13};
        assertEquals(2, BinarySearch.linearSearch(a, 8));
        assertEquals(0, BinarySearch.linearSearch(a, 1));
        assertEquals(-1, BinarySearch.linearSearch(a, 23));
        assertEquals(0, BinarySearch.linearSearch(a, 1));
        assertEquals(-1, BinarySearch.linearSearch(a, 11));
    }
}
