package exercises;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        checkPassword(password);
    }

    private static void checkPassword(String password) {
        boolean isValidLength = checkPassLength(password);
        boolean hasValidCharacters = checkCharacters(password);
        boolean hasEnoughDigits = checkDigits(password);
        if (!isValidLength) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        if (!hasValidCharacters) {
            System.out.println("Password must consist only of letters and digits");
        }

        if (!hasEnoughDigits) {
            System.out.println("Password must have at least 2 digits");
        }

        if (isValidLength && hasEnoughDigits && hasValidCharacters) {
            System.out.println("Password is valid");
        }
    }

    private static boolean checkPassLength(String password) {
        return password.length() >= 6 && password.length() <= 10;
    }

    private static boolean checkCharacters(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkDigits(String password) {
        int digitCount = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                digitCount++;
            }
        }

        return digitCount >= 2;
    }
}
