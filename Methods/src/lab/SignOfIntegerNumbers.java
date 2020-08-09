package lab;

import java.util.Scanner;

public class SignOfIntegerNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        printSigh(number);
    }

    public static void printSigh(int number) {
        if (number > 0) {
            System.out.printf("The number %d is positive.%n", number);
        } else if (number < 0) {
            System.out.printf("The number %d is negative.%n", number);
        } else {
            System.out.printf("The number %d is zero.%n", number);
        }
    }
}
