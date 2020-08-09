package moreExercises;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfInputs = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfInputs; i++) {
            String input = scanner.nextLine();
            if (Integer.parseInt(input) == 0) {
                System.out.print((char) 32);
            } else {
                int numberOfDigits = input.length();
                int mainNum = Integer.parseInt(input.charAt(input.length() - 1) + "");
                int offset;
                if (mainNum == 8 || mainNum == 9) {
                    offset = ((mainNum - 2) * 3) + 1;
                } else {
                    offset = (mainNum - 2) * 3;
                }

                int letterIndex = (offset + numberOfDigits - 1);
                System.out.print((char) (letterIndex + 97));
            }
        }
    }
}
