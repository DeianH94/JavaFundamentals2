package exercises;

import java.util.*;
import java.util.stream.Collectors;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();

        String[] inputLine = scanner.nextLine().split("\\s+:\\s+");

        while (!inputLine[0].equalsIgnoreCase("end")) {
            String courseName = inputLine[0];
            String studentName = inputLine[1];
            courses.putIfAbsent(courseName, new ArrayList<>());
            courses.get(courseName).add(studentName);

            inputLine = scanner.nextLine().split("\\s+:\\s+");
        }

        courses = courses.entrySet()
                .stream()
                .sorted((s1, s2) -> s2.getValue().size() - s1.getValue().size())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        courses.values().forEach(Collections::sort);

        for (var entry : courses.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
            for (String student : entry.getValue()) {
                System.out.println("-- " + student);
            }
        }
    }
}
