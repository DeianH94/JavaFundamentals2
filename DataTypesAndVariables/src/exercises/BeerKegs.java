package exercises;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfKegs = Integer.parseInt(scanner.nextLine());
        String biggestKagName = "";
        double biggestKegVolume = 0.0;

        for (int i = 0; i < numOfKegs; i++) {
            String kegName = scanner.nextLine();
            double kegRadius = Double.parseDouble(scanner.nextLine());
            double kegHeight = Double.parseDouble(scanner.nextLine());
            double kegVolume = Math.PI * Math.pow(kegRadius, 2) * kegHeight;

            if (kegVolume > biggestKegVolume) {
                biggestKegVolume = kegVolume;
                biggestKagName = kegName;
            }
        }

        System.out.println(biggestKagName);
    }
}
