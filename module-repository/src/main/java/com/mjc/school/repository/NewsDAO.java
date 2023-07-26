package com.mjc.school.repository;

import java.util.List;
import java.util.Optional;

public interface NewsDAO {
    List<News> findAll();

    News findById(int id);

    News createNews(News news);

    News updateNews(int id, News news);

    boolean deleteById(int id);
}
