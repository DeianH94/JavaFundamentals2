package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputStrings = new ArrayList(Arrays.asList(scanner.nextLine().split("\\s+")));

        String command = scanner.nextLine();

        while (!command.equals("3:1")) {
            String[] params = command.split("\\s+");
            String operation = params[0];

            if (operation.equalsIgnoreCase("merge")) {
                int startIndex = Integer.parseInt(params[1]);
                int endIndex = Integer.parseInt(params[2]);

                startIndex = Math.max(startIndex, 0);
                startIndex = Math.min(startIndex, inputStrings.size() - 1);
                endIndex = Math.max(endIndex, 0);
                endIndex = Math.min(endIndex, inputStrings.size() - 1);

                for (int i = endIndex; i > startIndex; i--) {
                    String merged = inputStrings.get(i - 1) + inputStrings.get(i);
                    inputStrings.set(i, merged);
                    inputStrings.remove(i - 1);
                }

            } else if (operation.equalsIgnoreCase("divide")) {
                int index = Integer.parseInt(params[1]);
                int partitions = Integer.parseInt(params[2]);
                int charsPerString = inputStrings.get(index).length() / partitions;

                for (int i = 0; i < partitions - 1; i++) {
                    String firstHalf = inputStrings.get(index + i).substring(0, charsPerString);
                    String secondHalf = inputStrings.get(index + i).substring(charsPerString);
                    inputStrings.set(index + i, firstHalf);
                    inputStrings.add(index + i + 1, secondHalf);
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(inputStrings.toString().replaceAll("[\\[\\],]", ""));
    }
}
