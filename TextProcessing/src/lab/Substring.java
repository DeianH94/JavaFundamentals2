package lab;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringToRemove = scanner.nextLine();
        String word = scanner.nextLine();

        while (word.contains(stringToRemove)) {
            word = word.replace(stringToRemove, "");
        }

        System.out.println(word);
    }
}
