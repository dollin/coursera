package week2;

import java.math.BigInteger;
import java.util.*;

public class FibonacciHuge {

    private static BigInteger calc_fib(int n) {
        if (n < 2) {
            return BigInteger.valueOf(n);
        }

        BigInteger[] numbers = new BigInteger[n + 1];
        numbers[0] = BigInteger.ZERO;
        numbers[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            numbers[i] = numbers[i - 1].add(numbers[i - 2]);
        }
        return numbers[n];
    }

    public static long getFibonacciHuge(long n, long m) {
        if (n <= 1) {
            return n;
        }

        int length = 0;
        long[] pisanoPeriod = new long[] {0, 1};
        do {
            long tmp = (pisanoPeriod[0] + pisanoPeriod[1]) % m;
            pisanoPeriod[0] = pisanoPeriod[1];
            pisanoPeriod[1] = tmp;
            length++;
        } while (!(pisanoPeriod[0] == 0 && pisanoPeriod[1] == 1));

        return calc_fib((int) (n % length)).mod(BigInteger.valueOf(m)).longValue();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}

