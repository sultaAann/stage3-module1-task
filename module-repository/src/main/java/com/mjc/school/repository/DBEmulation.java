package com.mjc.school.repository;

import java.util.ArrayList;
import java.util.List;

public class DBEmulation {
    List<News> news = new ArrayList<>();

    public List<News> getAll() {
        return news;
    }

    public News getNewsByID(int id) {
        return news.get(id);
    }

    public News create(News aNews) {
        news.add(aNews);
        return aNews;
    }

    public News update(int id, News aNews) {
        news.add(id, aNews);
        return aNews;
    }

    public boolean delete(int id) {
        int newsLength = news.size();
        news.remove(id);
        if (news.size() < newsLength) {
            return true;
        }
        return false;
    }
}
