package lab;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(",\\s+");
        String text = scanner.nextLine();

        for (String banWord : bannedWords) {
            if (text.contains(banWord)) {
                String replacement = repeatStr("*", banWord.length());
                text = text.replace(banWord, replacement);
            }
        }

        System.out.println(text);
    }

    private static String repeatStr(String str, int length) {
        StringBuilder replacement = new StringBuilder();

        for (int i = 0; i < length; i++) {
            replacement.append(str);
        }

        return replacement.toString();
    }
}
