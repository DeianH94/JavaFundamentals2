package exercises;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> sides = new LinkedHashMap<>();
        String command = scanner.nextLine();

        while (!command.equalsIgnoreCase("Lumpawaroo")) {
            String[] commandParams;
            String forceSide;
            String forceUser;
            if (command.contains("|")) {
                commandParams = command.split("\\s+\\|\\s+");
                forceSide = commandParams[0];
                forceUser = commandParams[1];
                boolean userExist = false;
                for (var entry : sides.entrySet()) {
                    if (entry.getValue().contains(forceUser)) {
                        userExist = true;
                        break;
                    }
                }

                if (!userExist) {
                    sides.putIfAbsent(forceSide, new TreeSet<>());
                    sides.get(forceSide).add(forceUser);
                }
            } else {
                commandParams = command.split("\\s+->\\s+");
                forceSide = commandParams[1];
                forceUser = commandParams[0];

                for (var entry : sides.entrySet()) {
                    entry.getValue().remove(forceUser);
                }

                sides.putIfAbsent(forceSide, new TreeSet<>());
                sides.get(forceSide).add(forceUser);
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }

            command = scanner.nextLine();
        }

        sides.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey()).sorted((s1, s2) -> s2.getValue().size() - s1.getValue().size())
                .filter(s -> s.getValue().size() > 0)
                .forEach(s -> {
                    System.out.printf("Side: %s, Members: %d%n", s.getKey(), s.getValue().size());
                    for (String forceUser : s.getValue()) {
                        System.out.println("! " + forceUser);
                    }
                });
    }
}
