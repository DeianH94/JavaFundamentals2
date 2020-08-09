package lab;

import java.util.Scanner;

public class BinaryDigitsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int bit = Integer.parseInt(scanner.nextLine());
        String binaryNumber = Integer.toBinaryString(number);

        int count = 0;

        for (int i = 0; i < binaryNumber.length(); i++) {
            if (Integer.parseInt(binaryNumber.substring(i, i + 1)) == bit) {
                count++;
            }
        }

        System.out.println(count);
    }
}
