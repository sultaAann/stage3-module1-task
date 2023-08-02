package com.mjc.school;

import com.mjc.school.controller.Controller;
import com.mjc.school.controller.impl.ControllerImpl;
import com.mjc.school.repository.Database.DataSource;
import com.mjc.school.service.exceptions.AuthorIDException;
import com.mjc.school.service.exceptions.NewsIDException;
import com.mjc.school.service.exceptions.TitleOrContentLengthException;

import java.util.Scanner;

public class IntputAndOutputSystem {
    private static final String COMMANDS = """
            Enter the number of operation:
            1 - Get all news.
            2 - Get news by id.
            3 - Create news.
            4 - Update news.
            5 - Remove news by id.
            0 - Exit.
            """;
    private static IntputAndOutputSystem intputAndOutputSystem;
    private final Scanner scanner;
    private Controller controller;
    private DataSource dataSource;

    private IntputAndOutputSystem(boolean bool) {
        this.dataSource = DataSource.getInstance();
        if (bool == true) {
            dataSource.readDefaultData();
        }
        this.scanner = new Scanner(System.in);
        this.controller = new ControllerImpl();
    }

    public static IntputAndOutputSystem getInstance(boolean bool) {
        if (intputAndOutputSystem == null) {
            intputAndOutputSystem = new IntputAndOutputSystem(bool);
        }
        return intputAndOutputSystem;
    }

    public void start() throws NewsIDException, AuthorIDException, TitleOrContentLengthException, InterruptedException {
        while (true) {
            System.out.print(COMMANDS);
            intputAndOutputSystem.select();
        }
    }

    private void select() throws NewsIDException, AuthorIDException, TitleOrContentLengthException, InterruptedException {
        if (scanner.hasNext()) {
            String num = scanner.nextLine();
            Thread.sleep(2000);
            if (num.equals("0")) {
                System.exit(1);
            } else if (num.equals("1")) {
                controller.getAll().forEach(System.out::println);
            } else if (num.equals("2")) {
                System.out.println("Operation: Get news by id.\n" + "Enter news id:");
                long id = Long.parseLong(scanner.nextLine());
                System.out.println(controller.getById(id));
            } else if (num.equals("3")) {
                System.out.println("Operation: Create news.\n" + "Enter news title:");
                String title = scanner.nextLine();
                System.out.println("Enter news content:");
                String content = scanner.nextLine();
                System.out.println("Enter author ID");
                long authorID = Long.parseLong(scanner.nextLine());
                System.out.println(controller.create(title, content, authorID));
            } else if (num.equals("4")) {
                System.out.println("Operation: update news.\n" + "Enter news ID");
                long id = Long.parseLong(scanner.nextLine());
                System.out.println("Enter news title:");
                String title = scanner.nextLine();
                System.out.println("Enter news content:");
                String content = scanner.nextLine();
                System.out.println("Enter author ID");
                long authorID = Long.parseLong(scanner.nextLine());
                System.out.println(controller.update(id, title, content, authorID));
            } else if (num.equals("5")) {
                System.out.println("Operation: delete news.\n" + "Enter news ID");
                long id = Long.parseLong(scanner.nextLine());
                System.out.println(controller.delete(id));
            } else {
                System.out.println("Command not found");
            }
        }
    }
}
