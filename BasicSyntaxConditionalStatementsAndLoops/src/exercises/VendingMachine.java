package exercises;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        final double THRESHOLD = 0.001;
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalMoney = 0;
        while (!input.toLowerCase().equals("start")) {
            double coin = Double.parseDouble(input);
            if (Math.abs(coin - 0.1) < THRESHOLD
                    || Math.abs(coin - 0.2) < THRESHOLD
                    || Math.abs(coin - 0.5) < THRESHOLD
                    || Math.abs(coin - 1) < THRESHOLD
                    || Math.abs(coin - 2) < THRESHOLD) {
                totalMoney += coin;
            } else {
                System.out.printf("Cannot accept %.2f%n", coin);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.toLowerCase().equals("end")) {
            switch (input.toLowerCase()) {
                case "nuts":
                    if (totalMoney >= 2) {
                        totalMoney -= 2;
                        System.out.printf("Purchased %s%n", input);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }

                    break;
                case "water":
                    if (totalMoney >= 0.7) {
                        totalMoney -= 0.7;
                        System.out.printf("Purchased %s%n", input);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }

                    break;
                case "crisps":
                    if (totalMoney >= 1.5) {
                        totalMoney -= 1.5;
                        System.out.printf("Purchased %s%n", input);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }

                    break;
                case "soda":
                    if (totalMoney >= 0.8) {
                        totalMoney -= 0.8;
                        System.out.printf("Purchased %s%n", input);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }

                    break;
                case "coke":
                    if (totalMoney >= 1.0) {
                        totalMoney -= 1.0;
                        System.out.printf("Purchased %s%n", input);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }

                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.printf("Change: %.2f%n", totalMoney);
    }
}
