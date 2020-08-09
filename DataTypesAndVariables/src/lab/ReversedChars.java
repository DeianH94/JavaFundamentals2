package lab;

import java.util.Scanner;

public class ReversedChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] charArr = new char[3];

        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = scanner.nextLine().charAt(0);
        }

        for (int i = charArr.length - 1; i >= 0; i--) {
            System.out.print(charArr[i] + " ");
        }
    }
}