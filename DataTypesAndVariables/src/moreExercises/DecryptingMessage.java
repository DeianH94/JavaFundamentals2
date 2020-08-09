package moreExercises;

import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int numOfLines = Integer.parseInt(scanner.nextLine());
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < numOfLines; i++) {
            char letter = scanner.nextLine().charAt(0);
            builder.append((char) (letter + key));
        }

        System.out.println(builder.toString());
    }
}
