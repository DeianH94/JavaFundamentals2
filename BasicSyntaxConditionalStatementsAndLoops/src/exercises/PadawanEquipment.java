package exercises;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalMoney = Double.parseDouble(scanner.nextLine());
        int studentCount = Integer.parseInt(scanner.nextLine());
        double lightSabrePrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        double totalPrice = 0;

        //add LightSabre total cost
        totalPrice += lightSabrePrice * (studentCount + Math.ceil(studentCount * 0.1));
        //add robes total cost
        int freeBelts = studentCount / 6;
        totalPrice += beltPrice * (studentCount - freeBelts);
        //add belts total cost
        totalPrice += robePrice * studentCount;

        if (totalMoney >= totalPrice) {
            System.out.printf("The money is enough - it would cost %.2flv.%n", totalPrice);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.%n", totalPrice - totalMoney);
        }
    }
}
