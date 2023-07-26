package com.mjc.school.repository;

import java.util.ArrayList;
import java.util.List;

public class DB {
    List<News> news = new ArrayList<>();

    public List<News> getAll() {
        return news;
    }
    public News getNewsByID(int id) {
        return news.get(id);
    }

    public void create(News aNews) {
        news.add(aNews);
    }
    public void update(int id, News aNews) {
        news.add(id, aNews);
    }
    public void delete(int id) {
        news.remove(id);
    }
}
