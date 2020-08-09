package exercises;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userName = scanner.nextLine();
        int incorrectCount = 0;

        while (incorrectCount < 3) {
            String password = scanner.nextLine();
            StringBuilder reverse = new StringBuilder();
            for(int i = userName.length() - 1; i >= 0; i--)
            {
                reverse.append(userName.charAt(i));
            }

            if (password.equals(reverse.toString())) {
                System.out.printf("User %s logged in.%n", userName);
                return;
            } else {
                System.out.println("Incorrect password. Try again.");
                incorrectCount++;
            }
        }

        System.out.printf("User %s blocked!%n", userName);
    }
}
