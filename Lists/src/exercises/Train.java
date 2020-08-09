package exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> passengersPerWagon = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxWagonCapacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equalsIgnoreCase("end")) {
            String[] params = command.split("\\s+");
            if (params[0].equalsIgnoreCase("add")) {
                passengersPerWagon.add(Integer.parseInt(params[1]));
            } else {
                int passengersToBoard = Integer.parseInt(params[0]);
                for (int i = 0; i < passengersPerWagon.size(); i++) {
                    if (passengersPerWagon.get(i) + passengersToBoard <= maxWagonCapacity) {
                        passengersPerWagon.set(i, passengersPerWagon.get(i) + passengersToBoard);
                        break;
                    }
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(passengersPerWagon.toString().replaceAll("[\\[\\],]", ""));
    }
}
