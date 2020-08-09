package exercises;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());
        int result = sum(firstNum, secondNum);
        result = subtract(result, thirdNum);

        System.out.println(result);
    }

    private static int sum(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }

    private static int subtract(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }
}
