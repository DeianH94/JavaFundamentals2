package exercises;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNUm = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());
        printSmallestNumber(firstNum, secondNUm, thirdNum);
    }

    private static void printSmallestNumber(int firstNum, int secondNum, int thirdNum) {
        int smallestNum = firstNum;
        if (smallestNum > secondNum) {
            smallestNum = secondNum;
        }

        if (smallestNum > thirdNum) {
            smallestNum = thirdNum;
        }

        System.out.println(smallestNum);
    }
}
