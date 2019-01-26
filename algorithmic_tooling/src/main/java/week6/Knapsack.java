package week6;

import java.util.*;

public class Knapsack {
    static int optimalWeight(int knapsackCapacity, int[] items) {

        int[][] values = new int[knapsackCapacity + 1][items.length + 1];

        for (int i = 0; i < values.length; i++) {
            values[i][0] = 0;
        }
        for (int i = 0; i < values[0].length; i++) {
            values[0][i] = 0;
        }

        for (int i = 1; i < items.length + 1; i++) {
            for (int w = 1; w < knapsackCapacity + 1; w++) {
                values[w][i] = values[w][i -1];
                if (items[i - 1] <= w) {
                    int val = values[w - items[i - 1]][i - 1] + items[i - 1];
                    if (values[w][i] < val) {
                        values[w][i] = val;
                    }
                }
            }
        }
        return values[knapsackCapacity][items.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}
