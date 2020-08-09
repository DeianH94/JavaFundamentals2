package exercises;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputStr = scanner.nextLine();
        printVowelsCount(inputStr);
    }

    private static void printVowelsCount(String str) {
        int vowelsCount = 0;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'a':
                case 'A':
                case 'e':
                case 'E':
                case 'i':
                case 'I':
                case 'o':
                case 'O':
                case 'u':
                case 'U':
                    vowelsCount++;
                    break;
            }
        }

        System.out.println(vowelsCount);
    }
}
