package lab;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");
        StringBuilder builder = new StringBuilder();

        for (String word : words) {
            builder.append(word.repeat(word.length()));
        }

        System.out.println(builder.toString());
    }
}
