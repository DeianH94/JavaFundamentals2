package moreExercises;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wantedNumber = Integer.parseInt(scanner.nextLine());

        System.out.println(getFibonacci(wantedNumber));
    }

    public static int getFibonacci (int wantedNumber) {
        if (wantedNumber < 2) {
            return wantedNumber;
        } else {
            return getFibonacci(wantedNumber - 1) + getFibonacci(wantedNumber - 2);
        }
    }
}
