package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean isTopInt = true;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] >= numbers[i]) {
                    isTopInt = false;
                    break;
                }
            }

            if (isTopInt) {
                System.out.print(numbers[i] + " ");
            }

            isTopInt = true;
        }
    }
}
