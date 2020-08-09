package exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> productPrices = new LinkedHashMap<>();
        Map<String, Integer> productQuantities = new LinkedHashMap<>();
        String[] productInfo = scanner.nextLine().split("\\s+");

        while (!productInfo[0].equalsIgnoreCase("buy")) {
            String productName = productInfo[0];
            double productPrice = Double.parseDouble(productInfo[1]);
            int productQuantity = Integer.parseInt(productInfo[2]);

            productPrices.put(productName, productPrice);

            if (!productQuantities.containsKey(productName)) {
                productQuantities.put(productName, productQuantity);
            } else {
                productQuantities.put(productName, productQuantities.get(productName) + productQuantity);
            }

            productInfo = scanner.nextLine().split("\\s+");
        }

        for (var entry : productPrices.entrySet()) {
            System.out.printf("%s -> %.2f%n",
                    entry.getKey(),
                    entry.getValue() * productQuantities.get(entry.getKey()));
        }
    }
}
