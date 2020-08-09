package moreExercises;

import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        final double THRESHOLD = 0.000001;
        Scanner scanner = new Scanner(System.in);

        double firstNum = Double.parseDouble(scanner.nextLine());
        double secondNum = Double.parseDouble(scanner.nextLine());

        if (Math.abs(firstNum - secondNum) < THRESHOLD) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
