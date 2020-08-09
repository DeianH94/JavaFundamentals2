package exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String emailRegex = "(?<user>[A-Za-z0-9]([-._]?[A-Za-z0-9])*)@(?<host>[A-Za-z](-?[A-Za-z])*(\\.[A-Za-z](-?[A-Za-z])*)+)";
        Pattern emailPattern = Pattern.compile(emailRegex);
        String text = scanner.nextLine();
        Matcher matcher = emailPattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
