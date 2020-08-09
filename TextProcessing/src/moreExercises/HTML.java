package moreExercises;

import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder builder = new StringBuilder();
        String article = scanner.nextLine();
        builder.append("<h1>").append(System.lineSeparator());
        builder.append(" ").append(article).append(System.lineSeparator());
        builder.append("</h1>").append(System.lineSeparator());
        String content = scanner.nextLine();
        builder.append("<article>").append(System.lineSeparator());
        builder.append(" ").append(content).append(System.lineSeparator());
        builder.append("</article>").append(System.lineSeparator());

        String comment = scanner.nextLine();

        while (!comment.equalsIgnoreCase("end of comments")) {
            builder.append("<div>").append(System.lineSeparator());
            builder.append(" ").append(comment).append(System.lineSeparator());
            builder.append("</div>").append(System.lineSeparator());

            comment = scanner.nextLine();
        }

        System.out.println(builder.toString());
    }
}
