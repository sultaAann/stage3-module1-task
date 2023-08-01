package com.mjc.school.repository.Database;

import com.mjc.school.repository.model.Author;
import com.mjc.school.repository.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private static DataSource INSTANCE;
    private final List<NewsModel> models = new ArrayList<>();
    private final List<Author> authors = new ArrayList<>();

    private DataSource() {
        readAll();
    }

    public static DataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataSource();
        }
        return INSTANCE;
    }

    public List<NewsModel> getModels() {
        return models;
    }
    private void readAll() {

    }
}
