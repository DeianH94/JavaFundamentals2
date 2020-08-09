package lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = new BigDecimal(0);

        for (int i = 0; i < numberOfLines; i++) {
            sum = sum.add(new BigDecimal(scanner.nextLine()));
        }

        System.out.println(sum);
    }
}
