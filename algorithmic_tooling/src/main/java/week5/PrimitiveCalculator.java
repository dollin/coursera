package week5;

import java.util.*;

public class PrimitiveCalculator {

    private static final Operation[] operations = new Operation[1_000_001];
    private static int lastIndex = 0;

    enum Type {PLUS1, TIMES2, TIMES3}

    static class Operation {
        Operation(Type type, int count) {
            this.type = type;
            this.count = count;
        }
        final Type type;
        final int count;
    }

    static List<Integer> optimal_sequence(int n) {
        if (lastIndex == 0) {
            operations[1] = new Operation(Type.PLUS1, 1);
            operations[2] = new Operation(Type.PLUS1, 2);
            operations[3] = new Operation(Type.TIMES3, 2);
            lastIndex = 3;
        }
        List<Integer> sequence = new ArrayList<>();
        Type type = Type.PLUS1;
        for (int i = lastIndex + 1; i <= n; i++) {
            int count = Integer.MAX_VALUE;
            if (i % 2 == 0) {
               count = operations[i /2].count;
               type = Type.TIMES2;
            }
            if (i % 3 == 0) {
                if (count == Integer.MAX_VALUE || count > operations[i / 3].count) {
                    count = operations[i / 3].count;
                    type = Type.TIMES3;
                }
            }
            if (count == Integer.MAX_VALUE || count > operations[i - 1].count) {
                count = operations[i - 1].count;
                type = Type.PLUS1;
            }
            operations[i] = new Operation(type, count + 1);
        }
        lastIndex = n;

        while (n >= 1) {
            sequence.add(n);
            if (operations[n].type == Type.TIMES2) {
                n /= 2;
            } else if (operations[n].type == Type.TIMES3) {
                n /= 3;
            } else {
                n--;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

