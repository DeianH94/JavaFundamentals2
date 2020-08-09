package exercises.articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] articleParams = scanner.nextLine().split(",");
        String title = articleParams[0];
        String content = articleParams[1];
        String author = articleParams[2];

        Article article = new Article(title, content, author);

        int numOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfCommands; i++) {
            String[] params = scanner.nextLine().split(":");
            String command = params[0];
            switch (command) {
                case "Edit":
                    String newContent = params[1];
                    article.edit(newContent);
                    break;
                case "ChangeAuthor":
                    String newAuthor = params[1];
                    article.changeAuthor(newAuthor);
                    break;
                case "Rename":
                    String newTitle = params[1];
                    article.rename(newTitle);
                    break;
            }
        }

        System.out.println(article);
    }
}
