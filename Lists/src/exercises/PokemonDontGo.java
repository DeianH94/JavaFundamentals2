package exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> distancesToPokemons = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sum = 0;

        while (distancesToPokemons.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());
            int removedNumber;
            if (index < 0) {
                removedNumber = distancesToPokemons.get(0);
                sum += removedNumber;
                distancesToPokemons.set(0, distancesToPokemons.get(distancesToPokemons.size() -1));
            } else if (index >= distancesToPokemons.size()) {
                removedNumber = distancesToPokemons.get(distancesToPokemons.size() - 1);
                sum += removedNumber;
                distancesToPokemons.set(distancesToPokemons.size() - 1, distancesToPokemons.get(0));
            } else {
                removedNumber = distancesToPokemons.remove(index);
                sum += removedNumber;
            }

            for (int i = 0; i < distancesToPokemons.size(); i++) {
                if (distancesToPokemons.get(i) <= removedNumber) {
                    distancesToPokemons.set(i, distancesToPokemons.get(i) + removedNumber);
                } else {
                    distancesToPokemons.set(i, distancesToPokemons.get(i) - removedNumber);
                }
            }
        }

        System.out.println(sum);
    }
}
