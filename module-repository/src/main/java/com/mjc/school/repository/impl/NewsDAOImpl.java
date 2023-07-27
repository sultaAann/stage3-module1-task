package com.mjc.school.repository.impl;

import com.mjc.school.repository.DBEmulation;
import com.mjc.school.repository.NewsDAO;

import java.util.List;

public class NewsDAOImpl implements NewsDAO {
    DBEmulation dbEmulation = DBEmulation.getInstance();

    @Override
    public List<News> readAll() {
        return dbEmulation.readAll();
    }

    @Override
    public News readById(int id) {
        return dbEmulation.readById(id);
    }

    @Override
    public News create(News news) {
        return dbEmulation.create(news);
    }

    @Override
    public News update(int id, News news) {
        return dbEmulation.update(id, news);
    }

    @Override
    public boolean deleteById(int id) {
        return dbEmulation.delete(id);
    }
}
