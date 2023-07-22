package com.mjc.school.service;

import java.util.Scanner;

public class InputSystem {
    private Scanner scanner;

    public InputSystem() {
        this.scanner = new Scanner(System.in);
    }

    public void select(){
        int num;
        if (scanner.hasNext()) {
            num = Integer.parseInt(scanner.next());

            if (num == 0) {
                System.exit(1);
            } else if (num == 1) {
                
            } else if (num == 2) {
                
            } else if (num == 3) {
                
            } else if (num == 4) {
                
            } else if (num == 5) {
                
            } else {
                System.out.println("Command not found");
            }
        }
    }
}
