package com.mjc.school.service.exceptions;

public class CommandNotFoundException extends Exception {
    public CommandNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
