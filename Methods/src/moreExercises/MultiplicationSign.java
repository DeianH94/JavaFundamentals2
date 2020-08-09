package moreExercises;

import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        System.out.println(findSign(firstNum, secondNum, thirdNum));
    }

    private static String findSign(int firstNum, int secondNum, int thirdNum) {
        int negativeCount = 0;
        if (firstNum == 0 || secondNum == 0 || thirdNum == 0) {
            return "zero";
        }

        if (firstNum < 0) {
            negativeCount++;
        }

        if (secondNum < 0) {
            negativeCount++;
        }

        if (thirdNum < 0) {
            negativeCount++;
        }

        if (negativeCount % 2 != 0) {
            return "negative";
        }

        return "positive";
    }
}
