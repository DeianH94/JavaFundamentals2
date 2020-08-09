package moreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().split(",\\s+");
        Pattern pattern = Pattern.compile("([\\^]{6,10}|[$]{6,10}|[@]{6,10}|[#]{6,10})");

        for (int i = 0; i < tickets.length; i++) {
            tickets[i] = tickets[i].trim();
        }

        for (String ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                String firstHalf = ticket.substring(0, ticket.length() / 2);
                String secondHalf = ticket.substring(ticket.length() / 2);

                Matcher firstMatcher = pattern.matcher(firstHalf);
                int firstLength = 0;
                if (firstMatcher.find()) {
                    firstLength = firstMatcher.group(0).length();
                }

                Matcher secondMatcher = pattern.matcher(secondHalf);
                int secondLength = 0;
                if (secondMatcher.find()) {
                    secondLength = secondMatcher.group(0).length();
                }

                int minLength = Math.min(firstLength, secondLength);

                if (minLength >= 6 && firstMatcher.toString().charAt(0) == secondMatcher.toString().charAt(0)) {
                    if (minLength <= 9) {
                        System.out.printf("ticket \"%s\" - %d%s%n", ticket, minLength, firstMatcher.group(0).charAt(0));
                    } else if (minLength == 10) {
                        System.out.printf("ticket \"%s\" - %d%s Jackpot!%n", ticket, minLength, firstMatcher.group(0).charAt(0));
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                }
            }
        }
    }
}
