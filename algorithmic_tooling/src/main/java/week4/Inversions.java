package week4;

import java.util.*;

public class Inversions {

    static long countInversions(int[] a, int[] aux, int low, int high) {
        long inversions = 0;
        if (high <= low) {
            return inversions;
        }
        int midpoint = low + (high - low) / 2;
        inversions += countInversions(a, aux, low, midpoint);
        inversions += countInversions(a, aux, midpoint + 1, high);

        return merge(a, aux, low, midpoint, high) + inversions;
    }

    private static long merge(int[] a, int[] aux, int low, int midpoint, int high) {
        long inversions = 0;

        System.arraycopy(a, low, aux, low, high + 1 - low);

        int i = low;
        int j = midpoint + 1;
        for (int k = low; k <= high; k++) {
            if (i > midpoint) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                inversions += j - k;
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
        return inversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(countInversions(a, b, 0, a.length - 1));
    }
}
