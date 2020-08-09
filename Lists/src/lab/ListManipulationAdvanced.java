package lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.toLowerCase().equals("end")) {
            String[] params = command.split("\\s+");

            switch (params[0]) {
                case "Contains":
                    int numberToFind = Integer.parseInt(params[1]);
                    if (numbers.contains(numberToFind)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }

                    break;
                case "Print":
                    List<Integer> partialList = new ArrayList<>();
                    String typeOfNum = params[1];
                    switch (typeOfNum) {
                        case "even":
                            for (Integer number : numbers) {
                                if (number % 2 == 0) {
                                    partialList.add(number);
                                }
                            }

                            break;
                        case "odd":
                            for (Integer number : numbers) {
                                if (number % 2 != 0) {
                                    partialList.add(number);
                                }
                            }

                            break;
                    }


                    System.out.println(partialList.toString().replaceAll("[\\[\\],]", ""));

                    break;
                case "Get":
                    int sum = 0;
                    for (Integer number : numbers) {
                        sum += number;
                    }

                    System.out.println(sum);
                    break;
                case "Filter":
                    List<Integer> filteredList = new ArrayList<>();
                    String condition = params[1];
                    int numberToFilter = Integer.parseInt(params[2]);
                    switch (condition) {
                        case ">=":
                            for (Integer number : numbers) {
                                if (number >= numberToFilter) {
                                    filteredList.add(number);
                                }
                            }

                            break;
                        case "<=":
                            for (Integer number : numbers) {
                                if (number <= numberToFilter) {
                                    filteredList.add(number);
                                }
                            }

                            break;
                        case "<":
                            for (Integer number : numbers) {
                                if (number < numberToFilter) {
                                    filteredList.add(number);
                                }
                            }

                            break;
                        case ">":
                            for (Integer number : numbers) {
                                if (number > numberToFilter) {
                                    filteredList.add(number);
                                }
                            }

                            break;
                    }

                    System.out.println(filteredList.toString().replaceAll("[\\[\\],]", ""));
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
