package exercises;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yield = Integer.parseInt(scanner.nextLine());
        int totalSpiceCollected = 0;
        int daysMined = 0;

        while (yield >= 100) {
            totalSpiceCollected += yield;
            totalSpiceCollected -= 26;
            yield -= 10;
            daysMined++;
        }

        totalSpiceCollected -= 26;
        if (totalSpiceCollected < 0) {
            totalSpiceCollected = 0;
        }

        System.out.println(daysMined);
        System.out.println(totalSpiceCollected);
    }
}
