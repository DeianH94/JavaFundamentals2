package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = ">>(?<product>[A-Za-z]+)<<(?<price>\\d+\\.?\\d*)!(?<quantity>\\d+)";

        List<String> furnitures = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);

        String furnitureString = scanner.nextLine();
        double furnitureSum = 0;
        while (!furnitureString.equalsIgnoreCase("purchase")) {
            Matcher furnitureMatcher = pattern.matcher(furnitureString);

            while (furnitureMatcher.find()) {
                String furnitureName = furnitureMatcher.group("product");
                double furniturePrice = Double.parseDouble(furnitureMatcher.group("price"));
                int furnitureQuantity = Integer.parseInt(furnitureMatcher.group("quantity"));

                furnitures.add(furnitureName);
                furnitureSum += furniturePrice * furnitureQuantity;
            }

            furnitureString = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        for (String furniture : furnitures) {
            System.out.println(furniture);
        }

        System.out.printf("Total money spend: %.2f%n", furnitureSum);
    }
}
