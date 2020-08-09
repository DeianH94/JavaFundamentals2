package exercises;

import java.util.*;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> userResults = new LinkedHashMap<>();
        Map<String, Integer> submissionCounts = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("exam finished")) {
            String[] params = input.split("-");
            String username = params[0];
            if (params[1].equalsIgnoreCase("banned")) {
                userResults.remove(username);
            } else {
                String language = params[1];
                int points = Integer.parseInt(params[2]);
                if (!userResults.containsKey(username)) {
                    userResults.put(username, 0);
                }

                userResults.put(username, Math.max(points, userResults.get(username)));

                if (!submissionCounts.containsKey(language)) {
                    submissionCounts.put(language, 0);
                }

                submissionCounts.put(language, submissionCounts.get(language) + 1);
            }

            input = scanner.nextLine();
        }

        System.out.println("Results:");
        userResults.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .forEach(u -> {
                    System.out.printf("%s | %d%n", u.getKey(), u.getValue());
                });

        System.out.println("Submissions:");
        submissionCounts.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                .forEach(s -> {
                    System.out.printf("%s - %d%n", s.getKey(), s.getValue());
                });
    }
}
