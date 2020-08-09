package lab;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine().toLowerCase();
        int quantity = Integer.parseInt(scanner.nextLine());

        printPrice(product, quantity);
    }

    private static void printPrice(String product, int quantity) {
        final double COFFEE_PRICE = 1.50;
        final double WATER_PRICE = 1.00;
        final double COKE_PRICE = 1.40;
        final double SNACKS_PRICE = 2.00;

        double price = 0;

        switch (product) {
            case "coffee":
                price = quantity * COFFEE_PRICE;
                break;
            case "water":
                price = quantity * WATER_PRICE;
                break;
            case "coke":
                price = quantity * COKE_PRICE;
                break;
            case "snacks":
                price = quantity * SNACKS_PRICE;
                break;
        }

        System.out.printf("%.2f", price);
    }
}
