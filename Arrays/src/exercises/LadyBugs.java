package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        int[] ladyBugsPositions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(e -> e >= 0 && e < fieldSize)
                .toArray();

        int[] field = new int[fieldSize];

        for (int ladyBugsPosition : ladyBugsPositions) {
            field[ladyBugsPosition] = 1;
        }

        String command = scanner.nextLine().toLowerCase();

        while (!command.equals("end")) {
            String[] params = command.split("\\s+");
            int startIndex = Integer.parseInt(params[0]);
            String direction = params[1];
            int distance = Integer.parseInt(params[2]);

            if (startIndex >= 0 && startIndex <field.length && field[startIndex] == 1) {
                field[startIndex] = 0;
                if (direction.equals("left")) {
                    distance = -distance;
                }

                int travel = distance;
                while (travel + startIndex >= 0
                        && travel + startIndex < field.length
                        && field[travel + startIndex] == 1) {
                    travel += distance;
                }

                if (travel + startIndex >= 0
                        && travel + startIndex < field.length) {
                    field[travel + startIndex] = 1;
                }
            }

            command = scanner.nextLine().toLowerCase();
        }

        for (int ladyBug : field) {
            System.out.print(ladyBug + " ");
        }
    }
}
