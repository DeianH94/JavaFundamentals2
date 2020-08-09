package exercises;

import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfLines = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 0; i < numOfLines; i++) {
            char currentLetter = scanner.nextLine().charAt(0);
            sum += currentLetter;
        }

        System.out.println("The sum equals: " + sum);
    }
}
