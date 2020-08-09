package moreExercises;

import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfLines; i++) {
            String line = scanner.nextLine();
            String name = line.substring(line.indexOf('@') + 1, line.indexOf('|'));
            String age = line.substring(line.indexOf('#') + 1, line.indexOf('*'));

            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}
