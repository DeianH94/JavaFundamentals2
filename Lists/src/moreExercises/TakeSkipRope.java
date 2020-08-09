package moreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < encryptedMessage.length(); i++) {
            if (Character.isDigit(encryptedMessage.charAt(i))) {
                numbers.add(Integer.valueOf(encryptedMessage.charAt(i) + ""));
                encryptedMessage = encryptedMessage.substring(0, i) + encryptedMessage.substring(i + 1);
                i--;
            }
        }

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numbers.get(i));
            } else {
                skipList.add(numbers.get(i));
            }
        }

        StringBuilder decryptedMessage = new StringBuilder();

        int index = 0;
        int count = 0;
        while (index < encryptedMessage.length() && count < takeList.size()) {
            if (index < index + takeList.get(count)) {
                decryptedMessage.append(encryptedMessage,
                        index,
                        Math.min(index + takeList.get(count), encryptedMessage.length()));
            }

            index += takeList.get(count);

            if (count < skipList.size()) {
                index += skipList.get(count);
            }

            count++;
        }

        System.out.println(decryptedMessage);
    }
}
