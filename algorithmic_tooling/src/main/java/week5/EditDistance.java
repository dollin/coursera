package week5;

import java.util.*;

class EditDistance {
    static int editDistance(String s, String t) {

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int[][] matrix = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = i;
        }
        for (int j = 1; j < matrix[0].length; j++) {
            matrix[0][j] = j;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                int insertOrDelete = Math.min(matrix[i][j - 1] + 1, matrix[i - 1][j] + 1);
                int diagonal = matrix[i - 1][j - 1];
                if (sChars[i - 1] == tChars[j - 1]) {
                    matrix[i][j] = Math.min(insertOrDelete, diagonal);
                } else {
                    matrix[i][j] = Math.min(insertOrDelete, diagonal + 1);
                }
            }
        }

        return matrix[s.length()][t.length()];
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(editDistance(s, t));
    }
}
