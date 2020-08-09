package moreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String regex = "@(?<name>[A-Za-z]+)[^@\\-!:>]+!(?<behavior>N|G)!";
        List<String> niceList = new ArrayList<>();
        int shiftNumber = Integer.parseInt(scanner.nextLine());
        String encryptedData = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        while (!encryptedData.equalsIgnoreCase("end")) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < encryptedData.length(); i++) {
                int newCharValue = encryptedData.charAt(i) - shiftNumber;
                builder.append((char) newCharValue);
            }

            matcher = pattern.matcher(builder.toString());
            if (matcher.find()) {
                String childName = matcher.group("name");
                String behavior = matcher.group("behavior");
                if (behavior.equals("G")) {
                    niceList.add(childName);
                }
            }

            encryptedData = scanner.nextLine();
        }

        for (String child : niceList) {
            System.out.println(child);
        }
    }
}
