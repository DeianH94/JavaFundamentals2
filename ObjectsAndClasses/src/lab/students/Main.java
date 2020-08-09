package lab.students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        String line = scanner.nextLine();

        while (!line.equalsIgnoreCase("end")) {
            String[] params = line.split("\\s+");
            String firstName = params[0];
            String lastName = params[1];
            int age = Integer.parseInt(params[2]);
            String hometown = params[3];

            Student student = new Student(firstName, lastName, age, hometown);
            students.add(student);

            line = scanner.nextLine();
        }

        String filterCity = scanner.nextLine();

        for (Student student : students) {
            if (student.getHometown().equalsIgnoreCase(filterCity)) {
                System.out.println(student);
            }
        }
    }
}
