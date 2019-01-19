package week3;

import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        return change(m, new int[]{10, 5, 1}, 0);
    }

    private static int change(int n, int[] coins, int index) {
        if (index >= coins.length) {
            return 0;
        }
        return (n / coins[index]) + change(n % coins[index], coins, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}
