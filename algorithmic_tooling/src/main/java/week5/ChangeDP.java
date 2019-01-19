package week5;

import java.util.Scanner;

public class ChangeDP {

    private static int[] startingValues = {0, 1, 2, 1, 1}; //if using coins = 4,3,1

    static int getChange(int m) {
        if (m <= 4) {
            return startingValues[m];
        }
        int[] dpSolution = new int[m];
        for (int i = 0; i < startingValues.length; i++) {
            dpSolution[i] = startingValues[i];
        }
        for (int i = 5; i < dpSolution.length; i++) {
            dpSolution[i] = 1 + Math.min(Math.min(dpSolution[i - 4], dpSolution[i - 3]), dpSolution[i - 1]);
        }
        return dpSolution[m - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
