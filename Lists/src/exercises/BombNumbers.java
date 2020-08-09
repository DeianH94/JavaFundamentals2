package exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] bombData = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int specialNumber = bombData[0];
        int power = bombData[1];

        while (numbers.contains(specialNumber)) {
            int bombIndex = numbers.indexOf(specialNumber);
            int leftmostIndex = Math.max(bombIndex - power, 0);
            for (int i = leftmostIndex; i <= bombIndex + power; i++) {
                if (leftmostIndex < numbers.size()) {
                    numbers.remove(leftmostIndex);
                }
            }
        }

        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        System.out.println(sum);
    }
}
