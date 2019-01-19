package week1;

import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {

    static long getMaxPairwiseProduct(int[] numbers) {
        int[] largest = new int[]{numbers[0], numbers[1]};
        if (numbers.length > 2) {
            for (int i = 2; i < numbers.length; i++) {
                if (numbers[i] > largest[0]) {
                    int tmp = largest[0];
                    largest[0] = numbers[i];
                    if (tmp > largest[1]) {
                        largest[1] = tmp;
                    }
                } else if (numbers[i] > largest[1]) {
                    largest[1] = numbers[i];
                }

            }
        }
        return largest[0] * (long) largest[1];
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}