package exercises;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("\\s+");
        String longerString;
        String shorterString;

        if (strings[0].length() >= strings[1].length()) {
            longerString = strings[0];
            shorterString = strings[1];
        } else {
            longerString = strings[1];
            shorterString = strings[0];
        }

        int sum = 0;
        for (int i = 0; i < shorterString.length(); i++) {
            sum += longerString.charAt(i) * shorterString.charAt(i);
        }

        for (int i = shorterString.length(); i < longerString.length(); i++) {
            sum += longerString.charAt(i);
        }

        System.out.println(sum);
    }
}
