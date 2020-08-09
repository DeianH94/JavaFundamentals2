package exercises;

import java.util.*;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> schedule = new ArrayList(Arrays.asList(scanner.nextLine().split(",\\s+")));

        String command = scanner.nextLine();

        while (!command.equalsIgnoreCase("course start")) {
            String[] params = command.split(":+");
            String operation = params[0];
            String lessonTitle = params[1];

            switch (operation.toLowerCase()) {
                case "add":
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(lessonTitle);
                    }

                    break;
                case "insert":
                    int index = Integer.parseInt(params[2]);
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(index, lessonTitle);
                    }

                    break;
                case "remove":
                    schedule.remove(lessonTitle);
                    break;
                case "swap":
                    String secondLessonTitle = params[2];
                    if (schedule.contains(lessonTitle) && schedule.contains(secondLessonTitle)) {
                        int firstLessonIndex = schedule.indexOf(lessonTitle);
                        int secondLessonIndex = schedule.indexOf(secondLessonTitle);
                        Collections.swap(schedule, firstLessonIndex, secondLessonIndex);
                        if (firstLessonIndex + 1 < schedule.size()
                                && schedule.get(firstLessonIndex + 1).equals(lessonTitle + "-Exercise")) {
                            schedule.add(secondLessonIndex + 1, schedule.remove(firstLessonIndex + 1));
                        }

                        if (secondLessonIndex + 1 < schedule.size()
                                && schedule.get(secondLessonIndex + 1).equals(secondLessonTitle + "-Exercise")) {
                            schedule.add(firstLessonIndex + 1, schedule.remove(secondLessonIndex + 1));
                        }
                    }

                    break;
                case "exercise":
                    String exercise = lessonTitle + "-Exercise";
                    if (schedule.contains(lessonTitle) && !schedule.contains(exercise)) {
                        int indexOfLesson = schedule.indexOf(lessonTitle);
                        schedule.add(indexOfLesson + 1, exercise);
                    } else if (!schedule.contains(lessonTitle)) {
                        schedule.add(lessonTitle);
                        schedule.add(exercise);
                    }

                    break;
            }

            command = scanner.nextLine();
        }

        for (int i = 0; i < schedule.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, schedule.get(i));
        }
    }
}
