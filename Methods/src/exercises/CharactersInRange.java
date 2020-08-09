package exercises;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        printCharactersInRange(firstChar, secondChar);
    }

    private static void printCharactersInRange(char firsChar, char lastChar) {
        for (int i = Math.min(firsChar, lastChar) + 1; i < Math.max(firsChar, lastChar); i++) {
            System.out.printf("%c ", i);
        }

        System.out.println();
    }
}
