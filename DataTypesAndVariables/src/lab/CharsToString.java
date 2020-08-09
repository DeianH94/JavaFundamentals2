package lab;

import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] charArr = new char[3];

        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = scanner.nextLine().charAt(0);
        }

        for (char c : charArr) {
            System.out.print(c);
        }
    }
}
