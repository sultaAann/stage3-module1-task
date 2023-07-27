package com.mjc.school.repository;

import java.util.List;

public class NewsDAOImpl implements NewsDAO {
    DBEmulation dbEmulation = DBEmulation.getInstance();

    @Override
    public List<News> findAll() {
        return dbEmulation.getAll();
    }

    @Override
    public News findById(int id) {
        return dbEmulation.getNewsByID(id);
    }

    @Override
    public News createNews(News news) {
        return dbEmulation.create(news);
    }

    @Override
    public News updateNews(int id, News news) {
        return dbEmulation.update(id, news);
    }

    @Override
    public boolean deleteById(int id) {
        return dbEmulation.delete(id);
    }
}
