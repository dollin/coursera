package week3;

import java.util.*;

public class DifferentSummands {
    static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<>();
        int nextPrize = 1;
        while (n > 0) {
            if (nextPrize <= n) {
                summands.add(nextPrize);
                n -= nextPrize;
                nextPrize++;
            } else {
                int lastPrize = summands.remove(summands.size() - 1) + n;
                summands.add(lastPrize);
                n -= lastPrize;
            }
        }
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

