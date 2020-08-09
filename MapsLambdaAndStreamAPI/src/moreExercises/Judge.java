package moreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> judge = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("no more time")) {
            String[] params = input.split("\\s+->\\s+");
            String username = params[0];
            String contest = params[1];
            int points = Integer.parseInt(params[2]);
            judge.putIfAbsent(contest, new LinkedHashMap<>());
            if (!judge.get(contest).containsKey(username)) {
                judge.get(contest).put(username, Integer.MIN_VALUE);
            }

            judge.get(contest).put(username, Math.max(judge.get(contest).get(username), points));

            input = scanner.nextLine();
        }

        judge.forEach((key, value) -> {
            final int[] counter = {1};
            System.out.printf("%s: %d participants%n", key, value.size());
            value.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .sorted((u1, u2) -> u2.getValue().compareTo(u1.getValue()))
                    .forEach(u -> {
                        System.out.printf("%d. %s <::> %d%n", counter[0], u.getKey(), u.getValue());
                        counter[0]++;
                    });
        });

        Map<String, Integer> participants = new TreeMap<>();
        for (var contest : judge.entrySet()) {
            for (var user : contest.getValue().entrySet()) {
                if (!participants.containsKey(user.getKey())) {
                    participants.put(user.getKey(), 0);
                }

                participants.put(user.getKey(), participants.get(user.getKey()) + user.getValue());
            }
        }

        System.out.println("Individual standings:");
        final int[] counter = {1};
        participants.entrySet().stream().sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue())).forEach(p -> {
            System.out.printf("%d. %s -> %d%n", counter[0], p.getKey(), p.getValue());
            counter[0]++;
        });
    }
}
