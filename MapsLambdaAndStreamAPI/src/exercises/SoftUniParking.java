package exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> parking = new LinkedHashMap<>();
        int numOfLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfLines; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            String command = line[0];
            String username = line[1];

            if (command.equalsIgnoreCase("register")) {
                String licencePlate = line[2];
                if (parking.containsKey(username)) {
                    System.out.println("ERROR: already registered with plate number " + parking.get(username));
                } else {
                    parking.put(username, licencePlate);
                    System.out.printf("%s registered %s successfully%n", username, licencePlate);
                }
            } else if (command.equalsIgnoreCase("unregister")) {
                if (!parking.containsKey(username)) {
                    System.out.printf("ERROR: user %s not found%n", username);
                } else {
                    parking.remove(username);
                    System.out.println(username + " unregistered successfully");
                }
            }
        }

        for (var entry : parking.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
