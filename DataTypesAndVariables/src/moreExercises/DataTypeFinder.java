package moreExercises;

import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String variableType = "";

        while (!input.toLowerCase().equals("end")) {
            if (tryParseInt(input)) {
                variableType = "integer";
            } else if (tryParseDouble(input)) {
                variableType = "floating point";
            } else if (tryParseChar(input)) {
                variableType = "character";
            } else if (tryParseBool(input)) {
                variableType = "boolean";
            } else {
                variableType = "string";
            }

            System.out.printf("%s is %s type%n", input, variableType);

            input = scanner.nextLine();
        }
    }

    public static boolean tryParseInt(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean tryParseDouble(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean tryParseChar(String string) {
        return string.length() == 1;
    }

    public static boolean tryParseBool(String string) {
        return string.toLowerCase().equals("true")
                || string.toLowerCase().equals("false");
    }
}
