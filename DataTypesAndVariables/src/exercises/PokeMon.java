package exercises;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pokePower = Integer.parseInt(scanner.nextLine());
        int startingPokePower = pokePower;
        int distanceToTargets = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int pokedTargets = 0;

        while (pokePower >= distanceToTargets) {
            pokePower -= distanceToTargets;
            pokedTargets++;
            if (pokePower * 2 == startingPokePower && exhaustionFactor > 0) {
                pokePower /= exhaustionFactor;
            }
        }

        System.out.println(pokePower);
        System.out.println(pokedTargets);
    }
}
