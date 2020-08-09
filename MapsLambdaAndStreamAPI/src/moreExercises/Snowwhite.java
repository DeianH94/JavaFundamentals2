package moreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Snowwhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> physicsByNameAndColor = new LinkedHashMap<>();
        Map<String, Integer> countByColor = new LinkedHashMap<>();

        String dwarfData = scanner.nextLine();

        while (!dwarfData.equalsIgnoreCase("once upon a time")) {
            String[] params = dwarfData.split("\\s+<:>\\s+");
            String dwarfName = params[0];
            String dwarfHatColor = params[1];
            int dwarfPhysics = Integer.parseInt(params[2]);

            countByColor.putIfAbsent(dwarfHatColor, 0);

            String nameAndColor = dwarfHatColor + ":" + dwarfName;
            if (physicsByNameAndColor.containsKey(nameAndColor)) {
                physicsByNameAndColor.put(nameAndColor, Math.max(dwarfPhysics, physicsByNameAndColor.get(nameAndColor)));
            } else {
                physicsByNameAndColor.put(nameAndColor, dwarfPhysics);
                countByColor.put(dwarfHatColor, countByColor.get(dwarfHatColor) + 1);
            }

            dwarfData = scanner.nextLine();
        }


        physicsByNameAndColor.entrySet().stream().sorted(
                (es1, es2) -> {
                    Integer physics2 = es2.getValue();
                    Integer physics1 = es1.getValue();

                    if (physics1.equals(physics2)) {
                        String key1 = es1.getKey();
                        String key2 = es2.getKey();

                        String color1 = key1.split(":")[0];
                        String color2 = key2.split(":")[0];

                        Integer count1 = countByColor.get(color1);
                        Integer count2 = countByColor.get(color2);

                        return Integer.compare(count2, count1);
                    }

                    return Integer.compare(physics2, physics1);
                }
        ).forEach(es -> {
                    String[] colorAndName = es.getKey().split(":");
                    System.out.printf("(%s) %s <-> %d%n",
                            es.getKey().split(":")[0],
                            es.getKey().split(":")[1],
                            es.getValue());
                });
    }
}
