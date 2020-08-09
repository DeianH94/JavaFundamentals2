package exercises;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            if (isTopNumber(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isTopNumber(int number) {
        int sum = 0;
        boolean containsOddDigit = false;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 != 0) {
                containsOddDigit = true;
            }
            
            sum += digit;
            number /= 10;
        }

        return sum % 8 == 0 && containsOddDigit;
    }
}
