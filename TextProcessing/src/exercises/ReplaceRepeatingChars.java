package exercises;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder builder = new StringBuilder();
        builder.append(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i - 1) != input.charAt(i)) {
                builder.append(input.charAt(i));
            }
        }

        System.out.println(builder.toString());
    }
}
