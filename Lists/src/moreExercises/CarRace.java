package moreExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        double firstRacerTime = 0;
        for (int i = 0; i < numbers.size() / 2; i++) {
            firstRacerTime = calculateRaceTime(numbers.get(i), firstRacerTime);
        }

        double secondRacerTime = 0;
        for (int i = numbers.size() - 1; i > numbers.size() / 2; i--) {
            secondRacerTime = calculateRaceTime(numbers.get(i), secondRacerTime);
        }

        if (firstRacerTime <= secondRacerTime) {
            System.out.printf("The winner is left with total time: %.1f", firstRacerTime);
        } else {
            System.out.printf("The winner is right with total time: %.1f", secondRacerTime);
        }
    }

    private static double calculateRaceTime(int lapTime, double racerTime) {
        if (lapTime == 0) {
            racerTime *= 0.8;
        } else {
            racerTime += lapTime;
        }

        return racerTime;
    }
}
