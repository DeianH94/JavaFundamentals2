package exercises;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split(", ");

        for (String username : usernames) {
            if (isValidUsername(username)) {
                System.out.println(username);
            }
        }
    }

    private static boolean isValidUsername(String username) {
        if (username.length() < 3 || username.length() > 16) {
            return false;
        }

        for (int i = 0; i < username.length(); i++) {
            char charToCheck = username.charAt(i);
            if (!Character.isLetterOrDigit(charToCheck)
                    && charToCheck != '_'
                    && charToCheck != '-') {
                return false;
            }
        }

        return true;
    }
}
