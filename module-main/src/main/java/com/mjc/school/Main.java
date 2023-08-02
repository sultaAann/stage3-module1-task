package com.mjc.school;

import com.mjc.school.service.exceptions.AuthorIDException;
import com.mjc.school.service.exceptions.NewsIDException;
import com.mjc.school.service.exceptions.TitleOrContentLengthException;

public class Main {
    public static void main(String[] args) throws AuthorIDException, NewsIDException, TitleOrContentLengthException {
        InputSystem inputSystem = InputSystem.getInstance();
        inputSystem.start();
    }
}