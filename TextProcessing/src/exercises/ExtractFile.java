package exercises;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] fullPath = scanner.nextLine().split("\\\\");
        String[] file = fullPath[fullPath.length - 1].split("\\.");
        String fileName = file[0];
        String extension = file[1];

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);
    }
}
