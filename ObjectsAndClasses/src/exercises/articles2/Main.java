package exercises.articles2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Article> articles = new ArrayList<>();
        int numOfArticles = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfArticles; i++) {
            String[] articleParams = scanner.nextLine().split(",");
            String title = articleParams[0];
            String content = articleParams[1];
            String author = articleParams[2];

            Article article = new Article(title, content, author);
            articles.add(article);
        }

        String sortCriteria = scanner.nextLine();
        if (sortCriteria.equalsIgnoreCase("title")) {
            articles = articles.stream().sorted(Comparator.comparing(Article::getTitle)).collect(Collectors.toList());
        } else if (sortCriteria.equalsIgnoreCase("author")) {
            articles = articles.stream().sorted(Comparator.comparing(Article::getAuthor)).collect(Collectors.toList());
        } else if (sortCriteria.equalsIgnoreCase("content")) {
            articles = articles.stream().sorted(Comparator.comparing(Article::getContent)).collect(Collectors.toList());
        }

        articles.forEach(System.out::println);
    }
}
