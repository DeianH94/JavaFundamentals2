package lab;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().toLowerCase().split("\\s+");
        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String word : words) {
            if (!counts.containsKey(word)) {
                counts.put(word, 0);
            }

            counts.put(word, counts.get(word) + 1);
        }

        List<String> odds = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                odds.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ", odds));
    }
}
