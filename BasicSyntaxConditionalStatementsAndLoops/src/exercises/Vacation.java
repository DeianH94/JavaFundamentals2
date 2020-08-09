package exercises;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPeople = Integer.parseInt(scanner.nextLine());
        String typeOfPeople = scanner.nextLine().toLowerCase();
        String dayOfWeek = scanner.nextLine().toLowerCase();
        double price = 0.0;

        switch (typeOfPeople) {
            case "students":
                switch (dayOfWeek) {
                    case "friday":
                        price = numOfPeople * 8.45;
                        break;
                    case "saturday":
                        price = numOfPeople * 9.80;
                        break;
                    case "sunday":
                        price = numOfPeople * 10.46;
                        break;
                }

                if (numOfPeople >= 30) {
                    price -= price * 0.15;
                }
                break;
            case "business":
                if (numOfPeople >= 100) {
                    numOfPeople -= 10;
                }

                switch (dayOfWeek) {
                    case "friday":
                        price = numOfPeople * 10.90;
                        break;
                    case "saturday":
                        price = numOfPeople * 15.60;
                        break;
                    case "sunday":
                        price = numOfPeople * 16.00;
                        break;
                }
                break;
            case "regular":
                switch (dayOfWeek) {
                    case "friday":
                        price = numOfPeople * 15.00;
                        break;
                    case "saturday":
                        price = numOfPeople * 20.00;
                        break;
                    case "sunday":
                        price = numOfPeople * 22.50;
                        break;
                }

                if (numOfPeople >= 10 && numOfPeople <= 20) {
                    price -= price * 0.05;
                }
                break;
        }

        System.out.printf("Total price: %.2f%n", price);
    }
}
