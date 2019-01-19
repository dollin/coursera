package week3;

import java.util.*;

public class LargestNumber {
    static String largestNumber(String[] strings) {
        Arrays.sort(strings, (o1, o2) -> {
            int returnVal = 0;
            for (int i = 1; i <= Math.min(o1.length(), o2.length()); i++) {
                returnVal = o1.substring(0,i).compareTo(o2.substring(0,i));
                if (i == o1.length() && i == o2.length()) {
                    return returnVal;
                }
                if (returnVal == 0 && i == o1.length() && i < o2.length()) {
                    return compare(o2, i);
                }
                if (returnVal == 0 && i == o2.length() && i < o1.length()) {
                    return -1 * compare(o1, i);
                }
            }
            return returnVal;
        });

        StringBuilder sb = new StringBuilder();

        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]);
        }
        return sb.toString();
    }

    private static int compare(String number, int substringLength) {

        int returnVal = 0;
        int groups = (int) Math.ceil(number.length() / (double) substringLength);

        for (int j = 1; j < groups; j++) {
            for (int i = 1; i <= substringLength; i++) {
                returnVal = number.substring(0, i).compareTo(number.substring(j * substringLength, (j * substringLength) + i));
                if (returnVal != 0) {
                    return returnVal;
                }
            }
        }
        return returnVal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}
