package week2;

import java.util.Scanner;

public class GCD {

    public static int gcd_euclid(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd_euclid(b, a % b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(gcd_euclid(a, b));
    }
}
