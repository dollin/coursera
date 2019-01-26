package week6;

import java.util.Scanner;
import java.util.stream.LongStream;

public class PlacingParentheses {
    static long getMaximValue(String exp) {
        char[] chars = exp.toCharArray();
        int n = (chars.length + 1) / 2;
        long[][] maxs = new long[n][n];
        long[][] mins = new long[n][n];

        char[] ops = new char[n -1];
        for (int i = 0; i < ops.length; i++) {
            ops[i] = chars[(i * 2) + 1];
        }
        for (int i = 0; i < n; i++) {
            maxs[i][i] = chars[i * 2] - '0';
            mins[i][i] = chars[i * 2] - '0';
        }

        for (int s = 1; s < n; s++) {
            for (int i = 0; i < n - s; i++) {
                int j = i + s;
                long minAndMax[] = minAndMax(i, j, mins, maxs, ops);
                mins[i][j] = minAndMax[0];
                maxs[i][j] = minAndMax[1];
            }
        }
        //print(maxs);
        //print(mins);

        return maxs[0][n - 1];
    }

    private static long[] minAndMax(int i, int j, long[][] mins, long[][] maxs, char[] ops) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int k = i; k < j; k++) {
            long max_max = eval(maxs[i][k], maxs[k + 1][j], ops[k]);
            long max_min = eval(maxs[i][k], mins[k + 1][j], ops[k]);
            long min_max = eval(mins[i][k], maxs[k + 1][j], ops[k]);
            long min_min = eval(mins[i][k], mins[k + 1][j], ops[k]);

            min = LongStream.of(min, max_max, max_min, min_max, min_min).min().getAsLong();
            max = LongStream.of(max, max_max, max_min, min_max, min_min).max().getAsLong();
        }

        return new long[]{min, max};
    }

    private static void print(int[][] matrix) {
        System.out.println("-------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println("-------");
    }


    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}
