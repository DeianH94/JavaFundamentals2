package exercises;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();
        int sum = 0;

        for (int i = 0; i < number.length(); i++) {
            int digit = Integer.parseInt(number.charAt(i) + "");
            int factorial = 1;
            for (int j = 1; j <= digit; j++) {
                factorial *= j;
            }

            sum += factorial;
        }

        if (sum == Integer.parseInt(number)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
