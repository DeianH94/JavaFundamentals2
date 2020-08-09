package exercises;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersAndLetters = scanner.nextLine().split("\\s+");
        double sum = 0;

        for (String entry : numbersAndLetters) {
            char firstLetter = entry.charAt(0);
            char lastLetter = entry.charAt(entry.length() - 1);
            double number = Double.parseDouble(entry.substring(1, entry.length() - 1));

            if (Character.isLowerCase(firstLetter)) {
                number *= firstLetter - 97 + 1;
            } else {
                number /= firstLetter - 65 + 1;
            }

            if (Character.isLowerCase(lastLetter)) {
                number += lastLetter - 97 + 1;
            } else {
                number -= lastLetter - 65 + 1;
            }

            sum += number;
        }

        System.out.printf("%.2f%n", sum);
    }
}
