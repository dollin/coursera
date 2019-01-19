package week2;

import java.util.Scanner;

public class Fibonacci {

    public static long calc_fib(int n) {
        if (n < 2) {
            return n;
        }
        long[] numbers = new long[n + 1];
        numbers[0] = 0;
        numbers[1] = 1;
        for (int i = 2; i <= n; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }
        return numbers[n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(calc_fib(n));
    }
}
