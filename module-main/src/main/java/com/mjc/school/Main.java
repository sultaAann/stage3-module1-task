package com.mjc.school;

import com.mjc.school.repository.Database.DataSource;
import com.mjc.school.service.exceptions.AuthorIDException;
import com.mjc.school.service.exceptions.NewsIDException;
import com.mjc.school.service.exceptions.TitleOrContentLengthException;


public class Main {
    public static void main(String[] args) throws AuthorIDException, NewsIDException, TitleOrContentLengthException, InterruptedException {
        IntputAndOutputSystem intputAndOutputSystem = IntputAndOutputSystem.getInstance(true);
        intputAndOutputSystem.start();
    }
}