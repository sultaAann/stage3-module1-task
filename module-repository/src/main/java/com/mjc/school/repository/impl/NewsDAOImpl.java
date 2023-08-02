package com.mjc.school.repository.impl;

import com.mjc.school.repository.Database.DataSource;
import com.mjc.school.repository.NewsDAO;
import com.mjc.school.repository.model.NewsModel;

import java.time.LocalDateTime;
import java.util.List;

public class NewsDAOImpl implements NewsDAO<NewsModel> {

    private final DataSource db = DataSource.getInstance();

    @Override
    public List<NewsModel> readAll() {
        return db.getModels();
    }

    @Override
    public NewsModel readById(Long id) {
        List<NewsModel> models = db.getModels();
        return models.stream()
                .filter(newsModel -> newsModel.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public NewsModel create(NewsModel newsModel) {
        long id = db.getModels().size() + 1;
        newsModel.setId(id);
        newsModel.setCreateDate(LocalDateTime.now());
        db.getModels().add(newsModel);
        return newsModel;
    }

    @Override
    public NewsModel update(NewsModel newsModel) {
        newsModel.setLastUpdateDate(LocalDateTime.now());
        db.getModels().add(newsModel);
        return newsModel;
    }

    @Override
    public Boolean delete(long id) {
        NewsModel newsModel = readById(id);
        return db.getModels().remove(newsModel);
    }
}
