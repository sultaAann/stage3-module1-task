package com.mjc.school.service;

import com.mjc.school.controller.NewsPrinter;
import com.mjc.school.repository.impl.News;
import com.mjc.school.repository.NewsDAO;
import com.mjc.school.repository.impl.NewsDAOImpl;
import com.mjc.school.repository.impl.NewsDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputSystem {
    private final Scanner scanner;
    private NewsDAO newsDAO;
    private NewsPrinter newsPrinter;


    public InputSystem() {
        this.scanner = new Scanner(System.in);
        newsDAO = new NewsDAOImpl();
    }

    public void select() {
        int num;
        if (scanner.hasNext()) {
            num = Integer.parseInt(scanner.next());

            if (num == 0) {
                System.exit(1);
            } else if (num == 1) {
                List<NewsDTO> newsDTOS = new ArrayList<>();
                for (News news : newsDAO.readAll()) {
                    newsDTOS.add(NewsMapper.INSTANCE.newsToNewsDTO(news));
                }
                newsPrinter.printNews(newsDTOS);
            } else if (num == 2) {
                System.out.println("Operation: Get news by id.\n" +
                        "Enter news id:");
                int id = 0;
                if (scanner.hasNext()) {
                    id = Integer.parseInt(scanner.nextLine());
                }
                newsPrinter.printArticle(NewsMapper.INSTANCE.newsToNewsDTO(newsDAO.readById(id)));
            } else if (num == 3) {
                News news = new News();
                System.out.println("Enter news title:");
                String title = scanner.nextLine();
                if (title.length() < 5 || title.length() > 30)
                    System.out.println("News title can not be less than 5 and more than 30 symbols");
                System.out.println("Enter news content:");
                String content = scanner.nextLine();
                if (content.length() < 5 || content.length() > 255)
                    System.out.println("News content can not be less than 5 and more than 30 symbols");
                news.setTitle(title);
                news.setContent(content);
                news.setCreateDate(LocalDateTime.now());
                newsPrinter.printArticle(NewsMapper.INSTANCE.newsToNewsDTO(news));
            } else if (num == 4) {
                int id;
                System.out.println("Enter news id");
                id = Integer.parseInt(scanner.next());
                News news = newsDAO.readById(id);
                System.out.println("Enter news title:");
                String title = scanner.nextLine();
                if (title.length() < 5 || title.length() > 30)
                    System.out.println("News title can not be less than 5 and more than 30 symbols");
                System.out.println("Enter news content:");
                String content = scanner.nextLine();
                if (content.length() < 5 || content.length() > 255)
                    System.out.println("News content can not be less than 5 and more than 30 symbols");
                news.setTitle(title);
                news.setContent(content);
                newsPrinter.printArticle(NewsMapper.INSTANCE.newsToNewsDTO(news));
            } else if (num == 5) {
                int id;
                System.out.println("Enter news id");
                id = Integer.parseInt(scanner.next());
                System.out.println(newsDAO.deleteById(id));
            } else {
                System.out.println("Command not found");
            }
        }
    }
}
