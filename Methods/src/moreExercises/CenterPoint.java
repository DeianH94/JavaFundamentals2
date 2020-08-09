package moreExercises;

import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());
        printClosestCoordinatesToCenter(x1, y1, x2, y2);
    }

    private static void printClosestCoordinatesToCenter(int x1, int y1, int x2, int y2) {
        double firstCoordinatesDistance = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
        double secondCoordinatesDistance = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));

        if (firstCoordinatesDistance <= secondCoordinatesDistance) {
            System.out.printf("(%d, %d)%n", x1, y1);
        } else {
            System.out.printf("(%d, %d)%n", x2, y2);
        }
    }
}
