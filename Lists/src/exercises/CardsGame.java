package exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (firstPlayerCards.size() > 0 && secondPlayerCards.size() > 0) {
            if (firstPlayerCards.get(0) > secondPlayerCards.get(0)) {
                takeCards(firstPlayerCards, secondPlayerCards);
            } else if (secondPlayerCards.get(0) > firstPlayerCards.get(0)) {
                takeCards(secondPlayerCards, firstPlayerCards);
            } else {
                firstPlayerCards.remove(0);
                secondPlayerCards.remove(0);
            }
        }

        if (firstPlayerCards.size() > 0) {
            System.out.println("First player wins! Sum: " + calculateCardSum(firstPlayerCards));
        } else if (secondPlayerCards.size() > 0) {
            System.out.println("Second player wins! Sum: " + calculateCardSum(secondPlayerCards));
        }

    }

    private static void takeCards(List<Integer> winningCards, List<Integer> loosingCards) {
        int firstCard = winningCards.get(0);
        winningCards.remove(0);
        winningCards.add(firstCard);
        winningCards.add(loosingCards.get(0));
        loosingCards.remove(0);
    }

    private static int calculateCardSum(List<Integer> cardDeck) {
        int sum = 0;
        for (Integer card : cardDeck) {
            sum += card;
        }

        return sum;
    }
}
