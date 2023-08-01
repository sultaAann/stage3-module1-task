package com.mjc.school.repository.DAOImpl;

import com.mjc.school.repository.Database.DataSource;
import com.mjc.school.repository.NewsDAO;
import com.mjc.school.repository.model.NewsModel;

import java.time.LocalDateTime;
import java.util.List;

public class NewsDAOImpl implements NewsDAO<NewsModel> {

    private DataSource db = DataSource.getInstance();

    @Override
    public List<NewsModel> getAll() {
        return db.getModels();
    }

    @Override
    public NewsModel getById(long id) {
        List<NewsModel> models = db.getModels();
        return models.stream()
                .filter(newsModel -> newsModel.getId() == id)
                .findFirst().
                get();
    }

    @Override
    public NewsModel create(NewsModel newsModel) {
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
    public boolean delete(long id) {
        NewsModel newsModel = getById(id);
        return db.getModels().remove(newsModel);
    }
}
