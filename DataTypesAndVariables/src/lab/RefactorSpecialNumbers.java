package lab;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lastNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= lastNumber; i++) {
            int currentNumber = i;
            int sum = 0;
            while (currentNumber > 0) {
                sum += currentNumber % 10;
                currentNumber = currentNumber / 10;
            }

            String isSpecialNum;
            if (sum == 5 || sum == 7 || sum == 11) {
                isSpecialNum = "True";
            } else {
                isSpecialNum = "False";
            }

            System.out.printf("%d -> %s%n", i, isSpecialNum);
        }
    }
}
