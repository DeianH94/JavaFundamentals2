package lab;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");
        Random rnd = new Random();

        for (int i = 0; i < words.length; i++) {
            int randomNumber = rnd.nextInt(words.length);
            String temp = words[i];
            words[i] = words[randomNumber];
            words[randomNumber] = temp;
        }

        for (String word : words) {
            System.out.println(word);
        }
    }
}
