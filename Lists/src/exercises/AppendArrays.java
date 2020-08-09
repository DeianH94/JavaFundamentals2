package exercises;

import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] split = scanner.nextLine().split("\\|+");
        List<Integer> allArrays = new ArrayList<>();

        for (int i = split.length - 1; i >= 0; i--) {
            allArrays.addAll(Arrays.stream(split[i].split("\\s+"))
                    .filter(string -> !string.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        }

        System.out.println(allArrays.toString().replaceAll("[\\[\\],]", ""));
    }
}
