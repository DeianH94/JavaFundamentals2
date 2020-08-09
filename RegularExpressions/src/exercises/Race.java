package exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String nameRegex = "[A-Za-z]";
        final String distanceRegex = "\\d";

        Map<String, Integer> racersTimes = new LinkedHashMap<>();
        String[] racers = scanner.nextLine().split(",\\s+");
        for (String racer : racers) {
            racersTimes.put(racer, 0);
        }

        Pattern namePattern = Pattern.compile(nameRegex);
        Pattern distancePattern = Pattern.compile(distanceRegex);
        String racerData = scanner.nextLine();

        while (!racerData.equalsIgnoreCase("end of race")) {
            StringBuilder name = new StringBuilder();
            Matcher nameMatcher = namePattern.matcher(racerData);
            while (nameMatcher.find()) {
                name.append(nameMatcher.group());
            }

            String racerName = name.toString();

            int distance = 0;
            Matcher distanceMatcher = distancePattern.matcher(racerData);
            while (distanceMatcher.find()) {
                distance += Integer.parseInt(distanceMatcher.group());
            }

            if (racersTimes.containsKey(racerName)) {
                racersTimes.put(racerName, racersTimes.get(racerName) + distance);
            }

            racerData = scanner.nextLine();
        }

        List<String> names = racersTimes.entrySet()
                .stream()
                .sorted((r1, r2) -> r2.getValue().compareTo(r1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("1st place: " + names.get(0));
        System.out.println("2nd place: " + names.get(1));
        System.out.println("3rd place: " + names.get(2));
    }
}
