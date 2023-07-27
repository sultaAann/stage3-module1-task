package com.mjc.school.repository;

import com.mjc.school.repository.impl.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBEmulation {
    private static DBEmulation INSTANCE;
    private final List<Model> models = new ArrayList<>();

    private DBEmulation() {
    }

    public static DBEmulation getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DBEmulation();
        }

        return INSTANCE;
    }

    public List<Model> readAll() {
        return models;
    }

    public Model readById(Long id) {
        for (Model model : models) {
            if (model.getId() == id) {
                return model;
            }
        }
        System.out.println("No such article with this id: " + id);
        return null;
    }

    public Model create(Model model) {
        Scanner scanner = new Scanner(System.in);
        Long id = (long) models.size() + 1;
        model.setId(id);
        System.out.println("Enter news title:");
        String title = "";
        if (scanner.hasNext()) {
            title = scanner.nextLine();
        }
        if (title.length() < 5 || title.length() > 30)
            System.out.println("News title can not be less than 5 and more than 30 symbols");
        System.out.println("Enter news content:");
        String content = "";
        if (scanner.hasNext()) {
            content = scanner.nextLine();
        }
        if (content.length() < 5 || content.length() > 255)
            System.out.println("News content can not be less than 5 and more than 30 symbols");
        model.setTitle(title);
        model.setContent(content);
        model.setCreateDate(LocalDateTime.now());
        models.add(model);
        return model;

    }

    public Model update(Long id) {
        Scanner scanner = new Scanner(System.in);
        Model model = INSTANCE.readById(id);
        models.remove(model);
        String title = "";
        String content = "";
        Long authorId;
        while (true) {
            System.out.println("Enter news title:");
            title = scanner.nextLine();
            System.out.println("Enter news content:");
            content = scanner.nextLine();
            System.out.println("Enter author ID");
            authorId = Long.parseLong(scanner.nextLine());
            if (title.length() < 5 || title.length() > 30 || content.length() < 5 || content.length() > 255) {
                System.out.println("News title can not be less than 5 and more than 30 symbols");
                System.out.println("News content can not be less than 5 and more than 30 symbols");
            } else {
                break;
            }
        }
        model.setTitle(title);
        model.setContent(content);
        model.setAuthorID(authorId);
        model.setLastUpdateDate(LocalDateTime.now());
        models.add(model);
        return model;
    }

    public Boolean delete(Long id) {
        int newsLength = models.size();
        models.remove(id);
        return models.size() < newsLength;
    }
}
