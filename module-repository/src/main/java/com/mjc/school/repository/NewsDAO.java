package com.mjc.school.repository;

import com.mjc.school.repository.impl.News;

import java.util.List;

public interface NewsDAO {
    List<News> readAll();

    News readById(int id);

    News create(News news);

    News update(int id, News news);

    boolean deleteById(int id);
}
