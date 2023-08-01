package com.mjc.school.service;

import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.dto.NewsDTO;

import java.util.List;

public interface Service {
    List<NewsDTO> getAll();
    NewsDTO getById(long id);
    NewsDTO create(NewsModel newsModel);
    NewsDTO update(NewsModel newsModel);
    boolean delete(long id);
}
