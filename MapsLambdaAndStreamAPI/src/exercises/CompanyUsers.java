package exercises;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> companies = new LinkedHashMap<>();
        String[] data = scanner.nextLine().split("\\s+->\\s+");

        while (!data[0].equalsIgnoreCase("end")) {
            String companyName = data[0];
            String employee = data[1];
            companies.putIfAbsent(companyName, new LinkedHashSet<>());
            companies.get(companyName).add(employee);

            data = scanner.nextLine().split("\\s+->\\s+");
        }

        companies.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(c -> {
            System.out.println(c.getKey());
            for (String value : c.getValue()) {
                System.out.println("-- " + value);
            }
        });
    }
}
