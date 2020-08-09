package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfLines = Integer.parseInt(scanner.nextLine());

        int[] firstArr = new int[numOfLines];
        int[] secondArr = new int[numOfLines];

        for (int i = 0; i < numOfLines; i++) {
            int[] numberPair = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (i % 2 == 0) {
                firstArr[i] = numberPair[0];
                secondArr[i] = numberPair[1];
            } else {
                firstArr[i] = numberPair[1];
                secondArr[i] = numberPair[0];
            }
        }

        for (int value : firstArr) {
            System.out.print(value + " ");
        }

        System.out.println();
        for (int value : secondArr) {
            System.out.print(value + " ");
        }
    }
}
