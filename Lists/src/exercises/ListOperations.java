package exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equalsIgnoreCase("end")) {
            String[] params = command.split("\\s+");
            String operation = params[0];

            switch (operation.toLowerCase()) {
                case "add":
                    int numToAdd = Integer.parseInt(params[1]);
                    numbers.add(numToAdd);
                    break;
                case "remove":
                    int removeIndex = Integer.parseInt(params[1]);
                    if (removeIndex < numbers.size() && removeIndex >= 0) {
                        numbers.remove(removeIndex);
                    } else {
                        System.out.println("Invalid index");
                    }

                    break;
                case "insert":
                    int insertNumber = Integer.parseInt(params[1]);
                    int insertIndex = Integer.parseInt(params[2]);
                    if (insertIndex < numbers.size() && insertIndex >= 0) {
                        numbers.add(insertIndex, insertNumber);
                    } else {
                        System.out.println("Invalid index");
                    }

                    break;
                case "shift":
                    String direction = params[1];
                    int count = Integer.parseInt(params[2]);
                    if (direction.equalsIgnoreCase("right")) {
                        for (int i = 0; i < count; i++) {
                            int number = numbers.remove(numbers.size() - 1);
                            numbers.add(0, number);
                        }
                    } else if (direction.equalsIgnoreCase("left")) {
                        for (int i = 0; i < count; i++) {
                            int number = numbers.remove(0);
                            numbers.add(number);
                        }
                    }

                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
