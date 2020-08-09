package moreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfString = Integer.parseInt(scanner.nextLine());
        int[] encryptedArr = new int[numOfString];

        for (int i = 0; i < numOfString; i++) {
            String stringToEncrypt = scanner.nextLine();
            int sum = 0;
            for (int j = 0; j < stringToEncrypt.length(); j++) {
                char symbol = stringToEncrypt.charAt(j);
                switch (symbol) {
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
                        sum += symbol * stringToEncrypt.length();
                        break;
                    default:
                        sum += symbol / stringToEncrypt.length();
                        break;
                }
            }

            encryptedArr[i] = sum;
        }

        Arrays.sort(encryptedArr);

        for (int value : encryptedArr) {
            System.out.println(value);
        }
    }
}
