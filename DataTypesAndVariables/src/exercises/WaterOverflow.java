package exercises;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        final int WATER_TANK_CAPACITY = 255;
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());
        int totalWaterAmount = 0;

        for (int i = 0; i < numberOfLines; i++) {
            int waterQuantity = Integer.parseInt(scanner.nextLine());
            if (waterQuantity + totalWaterAmount <= WATER_TANK_CAPACITY) {
                totalWaterAmount += waterQuantity;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }

        System.out.println(totalWaterAmount);
    }
}
