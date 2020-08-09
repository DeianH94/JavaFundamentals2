package exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> attackedPlanet = new ArrayList<>();
        List<String> destroyedPlanet = new ArrayList<>();

        String shiftRegex = "[starSTAR]";
        Pattern shiftPattern = Pattern.compile(shiftRegex);
        Matcher shiftMatcher;

        String infoRegex = "@(?<planet>[A-Za-z]+)[^@\\-!:>]*:(?<population>\\d+)[^@\\-!:>]*!(?<attackType>[AD])![^@\\-!:>]*->(?<soldierCount>\\d+)";
        Pattern infoPattern = Pattern.compile(infoRegex);
        Matcher infoMatcher;

        int numOFMessages = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOFMessages; i++) {
            int shiftCount = 0;

            String encryptedMessage = scanner.nextLine();
            shiftMatcher = shiftPattern.matcher(encryptedMessage);
            while (shiftMatcher.find()) {
                shiftCount++;
            }

            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < encryptedMessage.length(); j++) {
                builder.append((char) (encryptedMessage.charAt(j) - shiftCount));
            }

            infoMatcher = infoPattern.matcher(builder.toString());
            if (infoMatcher.find()) {
                String planetName = infoMatcher.group("planet");
                String attackType = infoMatcher.group("attackType");
                if (attackType.equals("A")) {
                    attackedPlanet.add(planetName);
                } else if (attackType.equals("D")) {
                    destroyedPlanet.add(planetName);
                }
            }
        }

        Collections.sort(attackedPlanet);
        Collections.sort(destroyedPlanet);

        System.out.println("Attacked planets: " + attackedPlanet.size());
        for (String planet : attackedPlanet) {
            System.out.println("-> " + planet);
        }

        System.out.println("Destroyed planets: " + destroyedPlanet.size());
        for (String planet : destroyedPlanet) {
            System.out.println("-> " + planet);
        }
    }
}
