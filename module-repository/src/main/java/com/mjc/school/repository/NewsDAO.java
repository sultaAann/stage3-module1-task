package com.mjc.school.repository;

import com.mjc.school.repository.impl.News;

import java.util.List;

public interface NewsDAO {
    List<News> findAll();

    News findById(int id);

    News createNews(News news);

    News updateNews(int id, News news);

    boolean deleteById(int id);
}
