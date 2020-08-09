package moreExercises;

import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        getTribonacci(num);
    }

    public static void getTribonacci (int wantedNumber) {
        if (wantedNumber < 1) {
            return;
        }

        int first = 0;
        int second = 0;
        int third = 1;

        System.out.print(third + " ");

        for (int i = 3; i < wantedNumber + 2; i++)
        {
            int curr = first + second + third;
            first = second;
            second = third;
            third = curr;

            System.out.print(curr +" ");
        }
    }
}
