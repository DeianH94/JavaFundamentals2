package exercises;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstNum = scanner.nextLine();
        while (firstNum.startsWith("0")) {
            firstNum = firstNum.replaceFirst("0", "");
        }

        int secondNum = Integer.parseInt(scanner.nextLine());

        if (firstNum.equals("0") || secondNum == 0) {
            System.out.println(0);
            return;
        }

        StringBuilder multipliedNumber = new StringBuilder();
        int remainder = 0;

        for (int i = firstNum.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(firstNum.charAt(i) + "");
            int result = (digit * secondNum) + remainder;
            multipliedNumber.append(result % 10);
            remainder = result / 10;
        }

        if (remainder > 0) {
            multipliedNumber.append(remainder);
        }

        multipliedNumber.reverse();

        System.out.println(multipliedNumber.toString());
    }
}
