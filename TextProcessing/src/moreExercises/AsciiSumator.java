package moreExercises;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char lowLimitChar = scanner.nextLine().charAt(0);
        char highLimitChar = scanner.nextLine().charAt(0);
        String line = scanner.nextLine();
        int sum = 0;

        if (lowLimitChar > highLimitChar) {
            char temp = lowLimitChar;
            lowLimitChar = highLimitChar;
            highLimitChar = temp;
        }

        for (int i = 0; i < line.length(); i++) {
            char charToCheck = line.charAt(i);
            if (charToCheck > lowLimitChar && charToCheck < highLimitChar) {
                sum += charToCheck;
            }
        }

        System.out.println(sum);
    }
}
