package exercises;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputStr = scanner.nextLine();
        printMiddleCharacter(inputStr);
    }

    private static void printMiddleCharacter(String string) {
        if (string.length() % 2 == 0) {
            System.out.println(string.substring(
                    (string.length() / 2) - 1,
                    (string.length() / 2) + 1));
        } else {
            System.out.println(string.charAt(string.length() / 2) );
        }
    }
}
