package moreExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String inputString = scanner.nextLine();
        StringBuilder outputString = new StringBuilder();

        for (Integer number : numbers) {
            int sum = 0;
            int currentNumber = number;
            while (currentNumber > 0) {
                sum += currentNumber % 10;
                currentNumber /= 10;
            }

            int stringIndex = sum % inputString.length();
            outputString.append(inputString.charAt(stringIndex));
            inputString = inputString.substring(0, stringIndex) + inputString.substring(stringIndex + 1);
        }

        System.out.println(outputString);
    }
}
