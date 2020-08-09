package exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] command = scanner.nextLine().split("\\s+");

        while (!command[0].equalsIgnoreCase("end")) {
            if (command[0].equalsIgnoreCase("delete")) {
                int numberToRemove = Integer.parseInt(command[1]);
                numbers.removeAll(Collections.singleton(numberToRemove));
            } else if (command[0].equalsIgnoreCase("insert")) {
                int numberToInsert = Integer.parseInt(command[1]);
                int index = Integer.parseInt(command[2]);

                if (index < numbers.size()) {
                    numbers.add(index, numberToInsert);
                }
            }

            command = scanner.nextLine().split("\\s+");
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
