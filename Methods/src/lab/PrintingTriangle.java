package lab;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        printTriangle(n);
    }

    private static void printLine(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    private static void printTriangle(int n) {
        for (int i = 0; i < n; i++) {
            printLine(1, i);
        }

        printLine(1, n);

        for (int i = n - 1; i >= 1; i--) {
            printLine(1, i);
        }
    }
}
