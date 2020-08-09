package moreExercises;

import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());
        int x3 = Integer.parseInt(scanner.nextLine());
        int y3 = Integer.parseInt(scanner.nextLine());
        int x4 = Integer.parseInt(scanner.nextLine());
        int y4 = Integer.parseInt(scanner.nextLine());

        findDistanceLength(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    private static void findDistanceLength(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        double firstLineDistance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double secondLineDistance = Math.sqrt(Math.pow(x4 - x3, 2) + Math.pow(y4 - y3, 2));

        if (firstLineDistance >= secondLineDistance) {
            printClosestCoordinatesToCenter(x1, y1, x2, y2);
        } else {
            printClosestCoordinatesToCenter(x3, y3, x4, y4);
        }
    }

    private static void printClosestCoordinatesToCenter(int x1, int y1, int x2, int y2) {
        double firstCoordinatesDistance = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
        double secondCoordinatesDistance = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));

        if (firstCoordinatesDistance <= secondCoordinatesDistance) {
            System.out.printf("(%d, %d)(%d, %d)%n", x1, y1, x2, y2);
        } else {
            System.out.printf("(%d, %d)(%d, %d)%n", x2, y2, x1, y1);
        }
    }
}
