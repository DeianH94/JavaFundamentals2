package moreExercises;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String rageRegex = "(?<string>\\D+)(?<repeatCount>\\d+)";
        Set<Character> uniqueSymbols = new HashSet<>();
        String rageString = scanner.nextLine();

        Pattern ragePattern = Pattern.compile(rageRegex);
        Matcher rageMatcher = ragePattern.matcher(rageString);
        StringBuilder builder = new StringBuilder();

        while (rageMatcher.find()) {
            String stringToRepeat = rageMatcher.group("string");
            int repeatCount = Integer.parseInt(rageMatcher.group("repeatCount"));

            for (int i = 0; i < repeatCount; i++) {
                builder.append(stringToRepeat.toUpperCase());
            }
        }

        String stringToDisplay = builder.toString();

        for (int i = 0; i < stringToDisplay.length(); i++) {
            uniqueSymbols.add(stringToDisplay.charAt(i));
        }

        System.out.println("Unique symbols used: " + uniqueSymbols.size());
        System.out.println(builder.toString());
    }
}
