package week3;

import org.junit.Assert;
import org.junit.Test;

public class CoveringSegmentsTest {

    @Test
    public void coveringSegments1() {
        CoveringSegments.Segment[] segments = new CoveringSegments.Segment[3];

        segments[0] = new CoveringSegments.Segment(2, 5);
        segments[1] = new CoveringSegments.Segment(1, 3);
        segments[2] = new CoveringSegments.Segment(3, 6);

        Assert.assertEquals(1, CoveringSegments.optimalPoints(segments).length);
        Assert.assertEquals(3, CoveringSegments.optimalPoints(segments)[0]);
    }

    @Test
    public void coveringSegments2() {
        CoveringSegments.Segment[] segments = new CoveringSegments.Segment[4];

        segments[0] = new CoveringSegments.Segment(4, 7);
        segments[1] = new CoveringSegments.Segment(1, 3);
        segments[2] = new CoveringSegments.Segment(2, 5);
        segments[3] = new CoveringSegments.Segment(5, 6);

        Assert.assertEquals(2, CoveringSegments.optimalPoints(segments).length);
        Assert.assertEquals(3, CoveringSegments.optimalPoints(segments)[0]);
        Assert.assertEquals(6, CoveringSegments.optimalPoints(segments)[1]);
    }


    @Test
    public void coveringSegments3() {
        CoveringSegments.Segment[] segments = new CoveringSegments.Segment[7];

        segments[0] = new CoveringSegments.Segment(1, 3);
        segments[1] = new CoveringSegments.Segment(1, 2);
        segments[2] = new CoveringSegments.Segment(1, 1);
        segments[3] = new CoveringSegments.Segment(0, 1);
        segments[4] = new CoveringSegments.Segment(2, 4);
        segments[5] = new CoveringSegments.Segment(2, 4);
        segments[6] = new CoveringSegments.Segment(3, 4);

        Assert.assertEquals(2, CoveringSegments.optimalPoints(segments).length);
        Assert.assertEquals(1, CoveringSegments.optimalPoints(segments)[0]);
        Assert.assertEquals(4, CoveringSegments.optimalPoints(segments)[1]);
    }
}
 
