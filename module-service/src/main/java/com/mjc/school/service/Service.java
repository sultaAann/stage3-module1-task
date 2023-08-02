package com.mjc.school.service;

import com.mjc.school.service.dto.NewsDTO;

import java.util.List;

public interface Service {
    List<NewsDTO> getAll();
    NewsDTO getById(long id);
    NewsDTO create(String title, String content, long authorID);
    NewsDTO update(long id, String title, String content, long authorID);
    boolean delete(long id);
}
