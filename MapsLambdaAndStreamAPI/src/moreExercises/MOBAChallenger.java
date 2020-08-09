package moreExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> players = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("season end")) {
            String[] params;
            if (input.contains("vs")) {
                params = input.split("\\s+vs\\s+");
                String firstPlayer = params[0];
                String secondPlayer = params[1];

                if (players.containsKey(firstPlayer) && players.containsKey(secondPlayer)) {
                    boolean playerIsRemoved = false;
                    for (var first : players.get(firstPlayer).entrySet()) {
                        for (var second : players.get(secondPlayer).entrySet()) {
                            if (first.getKey().equals(second.getKey())) {
                                int firstPlayerTotalSkill = players.get(firstPlayer)
                                        .values()
                                        .stream()
                                        .mapToInt(Integer::valueOf)
                                        .sum();
                                int secondPlayerTotalSkill = players.get(secondPlayer)
                                        .values()
                                        .stream()
                                        .mapToInt(Integer::valueOf)
                                        .sum();

                                if (firstPlayerTotalSkill > secondPlayerTotalSkill) {
                                    players.remove(secondPlayer);
                                    playerIsRemoved = true;
                                } else if (secondPlayerTotalSkill > firstPlayerTotalSkill) {
                                    players.remove(firstPlayer);
                                    playerIsRemoved = true;
                                }
                            }

                            if (playerIsRemoved) {
                                break;
                            }
                        }

                        if (playerIsRemoved) {
                            break;
                        }
                    }
                }
            } else {
                params = input.split("\\s+->\\s+");
                String playerName = params[0];
                String position = params[1];
                int skill = Integer.parseInt(params[2]);
                players.putIfAbsent(playerName, new TreeMap<>());
                if (!players.get(playerName).containsKey(position)) {
                    players.get(playerName).put(position, Integer.MIN_VALUE);
                }

                players.get(playerName).put(position, Math.max(players.get(playerName).get(position), skill));
            }

            input = scanner.nextLine();
        }

        players.entrySet().stream().sorted((p1, p2) -> p2.getValue()
                .values()
                .stream()
                .mapToInt(Integer::valueOf)
                .sum()
                - p1.getValue()
                .values()
                .stream()
                .mapToInt(Integer::valueOf)
                .sum()).forEach(p -> {
            System.out.printf("%s: %d skill%n", p.getKey(), p.getValue().values().stream().mapToInt(Integer::valueOf).sum());
            p.getValue().entrySet().stream().sorted((r1, r2) -> r2.getValue().compareTo(r1.getValue())).forEach(r -> {
                System.out.printf("- %s <::> %d%n", r.getKey(), r.getValue());
            });
        });
    }
}
