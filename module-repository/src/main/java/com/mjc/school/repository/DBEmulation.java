package com.mjc.school.repository;

import com.mjc.school.repository.impl.News;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DBEmulation {
    private static DBEmulation INSTANCE;
    private List<News> news = new ArrayList<>();

    public List<News> readAll() {
        return news;
    }

    public News readById(int id) {
        return news.get(id);
    }

    public News create(News aNews) {
        aNews.setId(news.size() + 1);
        news.add(aNews);
        return aNews;
    }

    public News update(int id, News aNews) {
        aNews.setLastUpdateDate(LocalDateTime.now());
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

    private DBEmulation() {
    }

    public static DBEmulation getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new DBEmulation();
        }

        return INSTANCE;
    }
}
