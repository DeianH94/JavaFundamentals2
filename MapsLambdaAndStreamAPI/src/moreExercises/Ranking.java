package moreExercises;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contests = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> users = new LinkedHashMap<>();

        String contestInfo = scanner.nextLine();

        while (!contestInfo.equalsIgnoreCase("end of contests")) {
            String[] contestParams = contestInfo.split(":");
            String contestName = contestParams[0];
            String contestPassword = contestParams[1];
            contests.put(contestName, contestPassword);

            contestInfo = scanner.nextLine();
        }

        String submissionInfo = scanner.nextLine();

        while (!submissionInfo.equalsIgnoreCase("end of submissions")) {
            String[] submissionParams = submissionInfo.split("=>");
            String contestName = submissionParams[0];
            String contestPassword = submissionParams[1];
            String username = submissionParams[2];
            int points = Integer.parseInt(submissionParams[3]);

            if (contests.containsKey(contestName) && contests.get(contestName).equals(contestPassword)) {
                users.putIfAbsent(username, new LinkedHashMap<>());
                if (!users.get(username).containsKey(contestName)) {
                    users.get(username).put(contestName, 0);
                }

                users.get(username).put(contestName , Math.max(users.get(username).get(contestName), points));
            }

            submissionInfo = scanner.nextLine();
        }
        String bestUser = "";
        int bestPointsSum = Integer.MIN_VALUE;
        for (var entry : users.entrySet()) {
            int currentUserSum = 0;
            for (var course : entry.getValue().entrySet()) {
                currentUserSum += course.getValue();
            }

            if (currentUserSum > bestPointsSum) {
                bestPointsSum = currentUserSum;
                bestUser = entry.getKey();
            }
        }

        System.out.printf("Best candidate is %s with total %d points.%n", bestUser, bestPointsSum);
        System.out.println("Ranking: ");
        users.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(u -> {
            System.out.println(u.getKey());
            u.getValue().entrySet().stream().sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue())).forEach(c -> {
                System.out.printf("#  %s -> %d%n", c.getKey(), c.getValue());
            });
        });
    }
}
