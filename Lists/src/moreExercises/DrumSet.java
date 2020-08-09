package moreExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());

        List<Integer> drumsConditions = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> initialConditions = new ArrayList(drumsConditions);

        String command = scanner.nextLine();

        while (!command.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(command);

            for (int i = 0; i < drumsConditions.size(); i++) {
                drumsConditions.set(i, drumsConditions.get(i) - hitPower);
                if (drumsConditions.get(i) <= 0) {
                    double newDrumPrice = initialConditions.get(i) * 3;
                    if (savings >= newDrumPrice) {
                        drumsConditions.set(i, initialConditions.get(i));
                        savings -= newDrumPrice;
                    } else {
                        drumsConditions.remove(i);
                        initialConditions.remove(i);
                        i--;
                    }
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(drumsConditions.toString().replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.%n", savings);
    }
}
