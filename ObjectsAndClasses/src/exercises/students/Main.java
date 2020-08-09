package exercises.students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        int numOfStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfStudents; i++) {
            String[] studentInfo = scanner.nextLine().split("\\s+");
            String firstName = studentInfo[0];
            String lastName = studentInfo[1];
            double grade = Double.parseDouble(studentInfo[2]);

            Student student = new Student(firstName, lastName, grade);
            students.add(student);
        }

        students.stream()
                .sorted(Comparator.comparing(Student::getGrade).reversed())
                .forEach(System.out::println);
    }
}
