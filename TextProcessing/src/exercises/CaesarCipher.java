package exercises;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            int encryptedValue = line.charAt(i) + 3;
            char encryptedChar = (char) encryptedValue;
            builder.append(encryptedChar);
        }

        System.out.println(builder.toString());
    }
}
