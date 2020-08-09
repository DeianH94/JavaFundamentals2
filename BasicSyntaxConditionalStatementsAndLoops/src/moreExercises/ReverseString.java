package moreExercises;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder reverseString = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            reverseString.append(input.charAt(i));
        }

        System.out.println(reverseString.toString());
    }
}
