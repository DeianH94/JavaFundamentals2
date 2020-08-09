package lab;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        String[] days = new String[] {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"};

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        if (number > days.length || number <= 0) {
            System.out.println("Invalid day!");
        } else {
            System.out.println(days[number - 1]);
        }
    }
}
