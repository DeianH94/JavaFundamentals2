package exercises;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!command.toLowerCase().equals("end")) {
            int number = Integer.parseInt(command);
            System.out.println(isPalindrome(number));

            command = scanner.nextLine();
        }
    }

    private static boolean isPalindrome(int number) {
        int temp = number;
        int remainder;
        int sum = 0;
        while (number > 0) {
            remainder = number % 10;
            sum = (sum * 10) + remainder;
            number = number / 10;
        }

        return temp == sum;
    }
}
