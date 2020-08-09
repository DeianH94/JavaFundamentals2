package exercises;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder line = new StringBuilder(scanner.nextLine());
        int numOFExplosions = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '>') {
                numOFExplosions += Integer.parseInt(line.charAt(i + 1) + "");
            } else if (numOFExplosions > 0) {
                line.deleteCharAt(i);
                numOFExplosions--;
                i--;
            }
        }

        System.out.println(line.toString());
    }
}
