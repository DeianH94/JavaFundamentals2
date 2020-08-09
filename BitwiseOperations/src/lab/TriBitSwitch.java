package lab;

import java.util.Scanner;

public class TriBitSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int position = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < 3; i++) {
            number = number ^ (1 << position + i);
        }

        System.out.println(number);
    }
}
