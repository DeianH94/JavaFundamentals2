package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int maxLength = 1;
        int currentLength = 1;
        int startIndex = 0;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] == numbers[i]) {
                currentLength++;
            } else {
                currentLength = 1;
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
                startIndex = i + 1 - maxLength;
            }
        }

        for (int i = startIndex; i < startIndex + maxLength; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
