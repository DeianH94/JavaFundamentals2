package moreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] keys = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String encryptedLocation = scanner.nextLine();

        while (!encryptedLocation.equalsIgnoreCase("find")) {
            StringBuilder decryptedLocation = new StringBuilder();
            for (int i = 0; i < encryptedLocation.length(); i++) {
                int decryptedChar = encryptedLocation.charAt(i) - keys[i % keys.length];
                decryptedLocation.append((char) decryptedChar);
            }

            String type = decryptedLocation.substring(decryptedLocation.indexOf("&") + 1, decryptedLocation.lastIndexOf("&"));
            String coordinates = decryptedLocation
                    .substring(decryptedLocation.indexOf("<") + 1, decryptedLocation.indexOf(">"));

            System.out.printf("Found %s at %s%n", type, coordinates);
            encryptedLocation = scanner.nextLine();
        }
    }
}
