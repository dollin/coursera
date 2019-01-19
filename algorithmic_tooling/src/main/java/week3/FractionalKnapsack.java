package week3;

import java.util.Scanner;

public class FractionalKnapsack {
    static double getOptimalValue(int capacity, int[] values, int[] weights) {
        int size = values.length;
        double[] perUnit = new double[size];
        double value = 0;

        for (int i = 0; i < size; i++) {
            perUnit[i] = values[i] / (double) weights[i];
        }

        double maxPerUnit = 0;
        int maxIndex = 0;
        while (capacity > 0) {
            for (int i = 0; i < size; i++) {
                if (maxPerUnit < perUnit[i]) {
                    maxIndex = i;
                    maxPerUnit = perUnit[i];
                }
            }
            value += Math.min(values[maxIndex], capacity * perUnit[maxIndex]);
            capacity -= weights[maxIndex];
            perUnit[maxIndex] = 0;
            maxPerUnit = 0;
            maxIndex = 0;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
