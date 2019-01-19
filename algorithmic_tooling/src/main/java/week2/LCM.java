package week2;

import java.util.*;

public class LCM {

    private static int gcd_euclid(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd_euclid(b, a % b);
    }

    public static long lcm(int a, int b) {
        return (long) a * b / gcd_euclid(a, b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lcm(a, b));
    }
}
