package lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\b(?<day>\\d{2})([.\\-\\/])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b";
        String datesStrings = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher datesMatcher = pattern.matcher(datesStrings);

        while (datesMatcher.find()) {
            String day = datesMatcher.group("day");
            String month = datesMatcher.group("month");
            String year = datesMatcher.group("year");

            System.out.printf("Day: %s, Month: %s, Year: %s%n", day, month, year);
        }
    }
}
