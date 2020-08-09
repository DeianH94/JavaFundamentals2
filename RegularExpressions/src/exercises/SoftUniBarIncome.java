package exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "[^|$!.]*%(?<customer>[A-Z][a-z]+)%[^|$!.]*<(?<product>\\w+)>[^|$!.]*\\|(?<count>\\d+)\\|[^|$!.\\d]*(?<price>\\d+.?\\d*)\\$";
        Pattern receiptPattern = Pattern.compile(regex);
        Matcher receiptMatcher;
        double totalIncome = 0;

        String receipt = scanner.nextLine();
        while (!receipt.equalsIgnoreCase("end of shift")) {
            receiptMatcher = receiptPattern.matcher(receipt);
            if (receiptMatcher.find()) {
                String customer = receiptMatcher.group("customer");
                String product = receiptMatcher.group("product");
                int count = Integer.parseInt(receiptMatcher.group("count"));
                double price = Double.parseDouble(receiptMatcher.group("price"));
                double totalPrice = price * count;
                totalIncome += totalPrice;
                System.out.printf("%s: %s - %.2f%n", customer, product, totalPrice);
            }

            receipt = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f%n", totalIncome);
    }
}
