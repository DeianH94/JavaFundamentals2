package moreExercises;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataType = scanner.nextLine().toLowerCase();

        switch (dataType) {
            case "int":
                int intNumber = Integer.parseInt(scanner.nextLine());
                System.out.println(modifyInput(intNumber));
                break;
            case "real":
                double realNumber = Double.parseDouble(scanner.nextLine());
                System.out.println(modifyInput(realNumber));
                break;
            case "string":
                String string = scanner.nextLine();
                System.out.println(modifyInput(string));
                break;
        }
    }

    private static int modifyInput(int number) {
        return number * 2;
    }

    private static String modifyInput(double number) {
        return new DecimalFormat("0.00").format(number * 1.5);
    }

    private static String modifyInput(String string) {
        return "$" + string + "$";
    }
}
