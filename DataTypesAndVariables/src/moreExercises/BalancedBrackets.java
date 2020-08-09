package moreExercises;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfLines = Integer.parseInt(scanner.nextLine());
        boolean isBalanced = true;
        boolean isOpened = false;

        for (int i = 0; i < numOfLines; i++) {
            String input = scanner.nextLine();
            if (input.equals(")") && !isOpened) {
                isBalanced = false;
                break;
            } else if (input.equals(")")) {
                isOpened = false;
            }

            if (input.equals("(") && isOpened) {
                isBalanced = false;
                break;
            } else if (input.equals("(")) {
                isOpened = true;
            }
        }

        if (isBalanced && !isOpened) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
