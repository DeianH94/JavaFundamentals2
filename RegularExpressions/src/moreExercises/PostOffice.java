package moreExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String firstPartRegex = "([&#$%*])(?<letters>[A-Z]+)\\1";
        String[] postData = scanner.nextLine().split("\\|");
        Pattern firstPartPattern = Pattern.compile(firstPartRegex);
        Matcher firstPartMatcher = firstPartPattern.matcher(postData[0]);
        Map<Character, Integer> wordsLengths = new LinkedHashMap<>();
        List<String> words = new ArrayList<>();

        while (firstPartMatcher.find()) {
            String capitalLetters = firstPartMatcher.group("letters");
            for (int i = 0; i < capitalLetters.length(); i++) {
                wordsLengths.put(capitalLetters.charAt(i), 0);
            }
        }

        for (var entry : wordsLengths.entrySet()) {
            String secondPartRegex = (int) entry.getKey() + ":(?<wordLength>\\d{2})";
            Pattern secondPartPattern = Pattern.compile(secondPartRegex);
            Matcher secondPartMatcher = secondPartPattern.matcher(postData[1]);
            int length = 0;
            if (secondPartMatcher.find()) {
                length = Integer.parseInt(secondPartMatcher.group("wordLength"));
            }

            wordsLengths.put(entry.getKey(), length);
        }

        for (var entry : wordsLengths.entrySet()) {
            String thirdPartRegex = "(\\s|^)(?<word>" + entry.getKey() + "[^ ]{" + entry.getValue() + "})(\\s|$)";
            Pattern thirdPartPattern = Pattern.compile(thirdPartRegex);
            Matcher thirdPartMatcher = thirdPartPattern.matcher(postData[2]);
            if (thirdPartMatcher.find()) {
                String word = thirdPartMatcher.group("word");
                words.add(word);
            }
        }

        for (String word : words) {
            System.out.println(word);
        }
    }
}
