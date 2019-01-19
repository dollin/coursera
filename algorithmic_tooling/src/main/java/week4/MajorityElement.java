package week4;

import java.util.*;
import java.io.*;

public class MajorityElement {
    static int getMajorityElement(int[] a, int left, int right) {
        int majority = (a.length / 2) + 1;

        Map<Integer, Integer> m = new HashMap<>();

        for (int i: a) {
            if (m.containsKey(i)) {
                if (m.get(i) + 1 >= majority) {
                    return 1;
                }
            }
            m.put(i, m.getOrDefault(i, 0) + 1);
        }
        return 0;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(getMajorityElement(a, 0, a.length));
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