package exercises;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGameCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());
        double totalExpense = 0;
        int destroyedKeyboardCount = 0;

        for (int i = 1; i <= lostGameCount; i++) {
            boolean destroyedHeadset = false;
            boolean destroyedMouse = false;
            boolean destroyDisplay = false;
            if (i % 2 == 0) {
                totalExpense += headsetPrice;
                destroyedHeadset = true;
            }

            if (i % 3 == 0) {
                totalExpense += mousePrice;
                destroyedMouse = true;
            }

            if (destroyedHeadset && destroyedMouse) {
                totalExpense += keyboardPrice;
                destroyedKeyboardCount++;
                if (destroyedKeyboardCount % 2 == 0) {
                    destroyDisplay = true;
                }
            }

            if (destroyDisplay) {
                totalExpense += displayPrice;
            }
        }

        System.out.printf("Rage expenses: %.2f lv.%n", totalExpense);
    }
}
