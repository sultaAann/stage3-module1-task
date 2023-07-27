package com.mjc.school.service;

import com.mjc.school.controller.ModelPrinter;
import com.mjc.school.repository.impl.Model;
import com.mjc.school.repository.ModelDAO;
import com.mjc.school.repository.impl.ModelDAOImpl;
import com.mjc.school.repository.impl.ModelDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputSystem {
    private final Scanner scanner;
    private ModelDAO modelDAO;
    private ModelPrinter modelPrinter;


    public InputSystem() {
        this.scanner = new Scanner(System.in);
        modelDAO = new ModelDAOImpl();
    }

    public void select() {
        int num;
        if (scanner.hasNext()) {
            num = Integer.parseInt(scanner.next());

            if (num == 0) {
                System.exit(1);
            } else if (num == 1) {
                List<ModelDTO> newsDTOS = new ArrayList<>();
                for (Model model : modelDAO.readAll()) {
                    newsDTOS.add(ModelMapper.INSTANCE.newsToNewsDTO(model));
                }
                modelPrinter.printNews(newsDTOS);
            } else if (num == 2) {
                System.out.println("Operation: Get news by id.\n" +
                        "Enter news id:");
                long id = 0;
                if (scanner.hasNext()) {
                    id = Integer.parseInt(scanner.nextLine());
                }
                modelPrinter.printArticle(ModelMapper.INSTANCE.newsToNewsDTO(modelDAO.readById(id)));
            } else if (num == 3) {
                Model model = new Model();
                modelDAO.create(model);
                modelPrinter.printArticle(ModelMapper.INSTANCE.newsToNewsDTO(model));
            } else if (num == 4) {
                long id;
                System.out.println("Enter news id");
                id = Integer.parseInt(scanner.next());
                Model model = modelDAO.update(id);
                modelPrinter.printArticle(ModelMapper.INSTANCE.newsToNewsDTO(model));
            } else if (num == 5) {
                long id;
                System.out.println("Enter news id");
                id = Integer.parseInt(scanner.next());
                System.out.println(modelDAO.deleteById(id));
            } else {
                System.out.println("Command not found");
            }
        }
    }
}
