package week4;

import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {

    enum TYPE {START, POINT, END}

    static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        Segment[] segments = new Segment[starts.length + ends.length + points.length];

        for (int i = 0; i < starts.length; i++) {
            segments[i] = new Segment(starts[i], TYPE.START);
            segments[i + starts.length] = new Segment(ends[i], TYPE.END);
        }
        for (int i = 0; i < points.length; i++) {
            segments[i + starts.length * 2] = new Segment(points[i], TYPE.POINT, i);
        }
        Arrays.sort(segments);

        int[] counts = new int[points.length];

        int counter = 0;
        for (Segment segment : segments) {
            if (segment.type == TYPE.START) {
                counter++;
            } else if (segment.type == TYPE.END) {
                counter--;
            } else {
                counts[segment.originalIndex] = counter;
            }
        }
        return counts;
    }

    public static class Segment implements Comparable<Segment> {
        int value;
        TYPE type;
        int originalIndex;

        Segment(int value, TYPE type) {
            this(value, type, -1);
        }

        Segment(int value, TYPE type, int originalIndex) {
            this.value = value;
            this.type = type;
            this.originalIndex = originalIndex;
        }

        @Override
        public String toString() {
            return "[" + value + ", " + type + "]";
        }


        @Override
        public int compareTo(Segment o) {
            if (this.value == o.value) {
                return this.type.compareTo(o.type);
            }
            return this.value - o.value;
        }
    }

    static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

