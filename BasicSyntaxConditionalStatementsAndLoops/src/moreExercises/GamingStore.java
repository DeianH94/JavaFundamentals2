package moreExercises;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        double totalSpend = 0;
        String gameName = scanner.nextLine();

        while (!gameName.toLowerCase().equals("game time")) {
            double gamePrice = 0;
            switch (gameName) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    gamePrice = 39.99;
                    break;
                case "CS: OG":
                    gamePrice = 15.99;
                    break;
                case "Zplinter Zell":
                    gamePrice = 19.99;
                    break;
                case "Honored 2":
                    gamePrice = 59.99;
                    break;
                case "RoverWatch":
                    gamePrice = 29.99;
                    break;
            }

            if (gamePrice == 0) {
                System.out.println("Not Found");
            } else if (currentBalance >= gamePrice) {
                currentBalance -= gamePrice;
                totalSpend += gamePrice;
                System.out.println("Bought " + gameName);
            } else {
                System.out.println("Too Expensive");
            }

            if (currentBalance == 0) {
                System.out.println("Out of money!");
                return;
            }

            gameName = scanner.nextLine();
        }

        System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpend, currentBalance);
    }
}
