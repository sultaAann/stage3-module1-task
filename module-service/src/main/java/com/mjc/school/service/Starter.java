package com.mjc.school.service;

import com.mjc.school.service.exceptions.CommandNotFoundException;

public class Starter {

    private InputSystem inputSystem;
    private final String commands = "Enter the number of operation:\n"
            + "1 - Get all news.\n"
            + "2 - Get news by id.\n"
            + "3 - Create news.\n"
            + "4 - Update news.\n"
            + "5 - Remove news by id.\n"
            + "0 - Exit.\n";

    public void init() {
        inputSystem = new InputSystem();
    }

    public void start() {
        while (true) {
            System.out.print(commands);
            inputSystem.select();
        }
    }
}
