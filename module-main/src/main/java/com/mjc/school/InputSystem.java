package com.mjc.school;

import com.mjc.school.controller.Controller;
import com.mjc.school.controller.impl.ControllerImpl;
import com.mjc.school.service.exceptions.AuthorIDException;
import com.mjc.school.service.exceptions.NewsIDException;
import com.mjc.school.service.exceptions.TitleOrContentLengthException;

import java.util.Scanner;

public class InputSystem {
    private static final String COMMANDS = """
            Enter the number of operation:
            1 - Get all news.
            2 - Get news by id.
            3 - Create news.
            4 - Update news.
            5 - Remove news by id.
            0 - Exit.
            """;
    private static InputSystem inputSystem;
    private final Scanner scanner;
    private Controller controller;

    private InputSystem() {
        this.scanner = new Scanner(System.in);
        this.controller = new ControllerImpl();
    }

    public static InputSystem getInstance() {
        if (inputSystem == null) {
            inputSystem = new InputSystem();
        }
        return inputSystem;
    }

    public void start() throws NewsIDException, AuthorIDException, TitleOrContentLengthException {
        while (true) {
            System.out.print(COMMANDS);
            inputSystem.select();
        }
    }

    private void select() throws NewsIDException, AuthorIDException, TitleOrContentLengthException {
        int num;
        if (scanner.hasNext()) {
            num = Integer.parseInt(scanner.next());

            if (num == 0) {
                System.exit(1);
            } else if (num == 1) {
                controller.getAll().forEach(System.out::println);
            } else if (num == 2) {
                System.out.println("Operation: Get news by id.\n" + "Enter news id:");
                long id = Long.parseLong(scanner.nextLine());
                System.out.println(controller.getById(id));
            } else if (num == 3) {
                System.out.println("Operation: Create news.\n" + "Enter news title:");
                String title = scanner.nextLine();
                System.out.println("Enter news content:");
                String content = scanner.nextLine();
                System.out.println("Enter author ID");
                long authorID = Long.parseLong(scanner.nextLine());
                System.out.println(controller.create(title, content, authorID));
            } else if (num == 4) {
                System.out.println("Operation: update news.\n" + "Enter news ID");
                long id = Long.parseLong(scanner.nextLine());
                System.out.println("Enter news title:");
                String title = scanner.nextLine();
                System.out.println("Enter news content:");
                String content = scanner.nextLine();
                System.out.println("Enter author ID");
                long authorID = Long.parseLong(scanner.nextLine());
                System.out.println(controller.update(id, title, content, authorID));
            } else if (num == 5) {
                System.out.println("Operation: delete news.\n" + "Enter news ID");
                long id = Long.parseLong(scanner.nextLine());
                System.out.println(controller.delete(id));
            } else {
                System.out.println("Command not found");
            }
        }
    }
}
