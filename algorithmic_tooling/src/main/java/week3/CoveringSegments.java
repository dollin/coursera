package week3;

import java.util.*;

public class CoveringSegments {

    public static int[] optimalPoints(Segment[] segments) {
        Arrays.sort(segments);
        Set<Integer> pts = new TreeSet<>();

        int endPoint = segments[0].end;
        pts.add(endPoint);

        for (int i = 1; i < segments.length; i++) {
            if (segments[i].start > endPoint || endPoint > segments[i].end) {
                endPoint = segments[i].end;
            }
            pts.add(endPoint);
        }
        int[] points = new int[pts.size()];
        int i = 0;
        for (int point: pts) {
            points[i] = point;
            i++;
        }
        return points;
    }

    public static class Segment implements Comparable<Segment> {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }


        @Override
        public int compareTo(Segment o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
