package week2;

import java.util.*;

public class FibonacciSumLastDigit {

    private static long calc_fib(long n) {
        if (n < 2) {
            return n;
        }

        long previous = 0;
        long current = 1;

        for (int i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous % 10 + current) % 10;
        }
        return current;
    }

    public static long getFibonacciSumLastDigit(long n) {
        if (n <= 1) {
            return n;
        }
        int length = 0;
        long[] pisanoPeriod = new long[] {0, 1};
        do {
            long tmp = (pisanoPeriod[0] + pisanoPeriod[1]) % 10;
            pisanoPeriod[0] = pisanoPeriod[1];
            pisanoPeriod[1] = tmp;
            length++;
        } while (!(pisanoPeriod[0] == 0 && pisanoPeriod[1] == 1));

        return ((calc_fib((n + 2) % length) + 10) - 1) % 10;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumLastDigit(n);
        System.out.println(s);
    }
}
