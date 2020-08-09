package exercises;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfWagons = Integer.parseInt(scanner.nextLine());
        int[] passengersPerWagon = new int[numOfWagons];
        int totalPassengers = 0;

        for (int i = 0; i < passengersPerWagon.length; i++) {
            passengersPerWagon[i] = Integer.parseInt(scanner.nextLine());
            totalPassengers += passengersPerWagon[i];
        }

        for (int passengers : passengersPerWagon) {
            System.out.print(passengers + " ");
        }

        System.out.println();
        System.out.println(totalPassengers);
    }
}
