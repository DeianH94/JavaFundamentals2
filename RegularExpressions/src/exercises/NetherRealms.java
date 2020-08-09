package exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String healthRegex = "[^0-9+\\-*/.]";
        final String damageRegex = "-*\\d+\\.?\\d*";
        final String modifierRegex = "[/*]";

        List<String> demonNames = Arrays.stream(scanner.nextLine().split(",\\s*"))
                .sorted()
                .collect(Collectors.toList());

        Pattern healthPattern = Pattern.compile(healthRegex);
        Pattern damagePattern = Pattern.compile(damageRegex);
        Pattern modifierPattern = Pattern.compile(modifierRegex);
        Matcher healthMatcher;
        Matcher damageMatcher;
        Matcher modifierMatcher;
        for (String demonName : demonNames) {
            demonName = demonName.replace(" ", "");
            int healthSum = 0;
            healthMatcher = healthPattern.matcher(demonName);
            while (healthMatcher.find()) {
                healthSum += healthMatcher.group().charAt(0);
            }

            double damageSum = 0;
            damageMatcher = damagePattern.matcher(demonName);
            while (damageMatcher.find()) {
                damageSum += Double.parseDouble(damageMatcher.group());
            }

            modifierMatcher = modifierPattern.matcher(demonName);
            while (modifierMatcher.find()) {
                char modifierChar = modifierMatcher.group().charAt(0);
                if (modifierChar == '*') {
                    damageSum *= 2;
                } else if (modifierChar == '/') {
                    damageSum /= 2;
                }
            }

            System.out.printf("%s - %d health, %.2f damage%n", demonName, healthSum, damageSum);
        }
    }
}
