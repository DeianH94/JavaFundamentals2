package lab;

import java.util.Scanner;

public class FirstBit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        number = number >> 1;
        System.out.println(number & 1);
    }
}
