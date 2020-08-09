package moreExercises;

import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfLines; i++) {
            String input = scanner.nextLine();
            int spacePosition = input.indexOf(' ');
            long firstNum = Long.parseLong(input.substring(0, spacePosition));
            long secondNum = Long.parseLong(input.substring(spacePosition + 1));
            long biggerNum = Math.max(firstNum, secondNum);
            int sum = 0;

            while (biggerNum != 0) {
                sum += biggerNum % 10;
                biggerNum /= 10;
            }

            System.out.println(Math.abs(sum));
        }
    }
}
